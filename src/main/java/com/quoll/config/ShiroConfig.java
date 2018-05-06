package com.quoll.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.github.pagehelper.util.StringUtil;
import com.quoll.model.Resources;
import com.quoll.service.ResourcesService;
import com.quoll.shiro.MyShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Autowired(required = false)
    private ResourcesService resourcesService;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;


    /**
     * ShiroDialect，in order to use the bean of shiro in thymeleaf
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
    /**
     * ShiroFilterFactoryBean: Handling interception resource file issues.
     * Note: A separate shiroFilterFactoryBean configuration maybe wrong,
     * since when initializing ShiroFilterFactoryBean, SecurityManager should be injected
     *
     Filter Chain definition
     1、a URL can be configured with multiple filters, separated by ','
     2、when setting up multiple filters, only if all verified through, it seen as pass 
     3、part of the filter can specify parameters，such as perms, roles
     *
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean  = new ShiroFilterFactoryBean();

        // set up SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // automatically search the root directory "/login.jsp" of Web project, if no default
        shiroFilterFactoryBean.setLoginUrl("/login");
        // the link for successful login
        shiroFilterFactoryBean.setSuccessUrl("/moduleNavigation");
        // unauthorized interface;
        shiroFilterFactoryBean.setUnauthorizedUrl("/error/401");
        // Intercepter.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();

        //Configure exiting, filter
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/css/**","anon");
        filterChainDefinitionMap.put("/js/**","anon");
        filterChainDefinitionMap.put("/img/**","anon");
        filterChainDefinitionMap.put("/font-awesome/**","anon");
        filterChainDefinitionMap.put("/login/**","anon");
        filterChainDefinitionMap.put("/Resources/**","anon");
        //<! - filter chain definition, the execution order is from top to bottom in the order of execution, the general one is / ** on the bottom of the most ->:
        //<!-- authc:all url must through authentication when access; anon: all url can be anonymous accessed-->
        //Customize the load permission resource relationship
        List<Resources> resourcesList = resourcesService.queryAll();
         for(Resources resources:resourcesList){

            if (StringUtil.isNotEmpty(resources.getResurl())) {
                String permission = "perms[" + resources.getResurl()+ "]";
                filterChainDefinitionMap.put(resources.getResurl(),permission);
            }
        }
        filterChainDefinitionMap.put("/**", "authc");


        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }


    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        //set up realm.
        securityManager.setRealm(myShiroRealm());
        // Customize cache implementation, use redis
        //securityManager.setCacheManager(cacheManager());
        // Customize session management, use redis
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    @Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }

    /**
     *  Certificate Matcher
     * （Due to password check is proceeded by SimpleAuthenticationInfo of Shiro,
     *  codes in doGetAuthenticationInfo are modified
     * ）
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();

        hashedCredentialsMatcher.setHashAlgorithmName("md5");// hash algorithm: using MD5 algorithm;
        hashedCredentialsMatcher.setHashIterations(2);//The number of hashes, such as the hash twice, is equivalent to md5 (md5 (""));

        return hashedCredentialsMatcher;
    }


    /**
     *  opoen shiro aop annnotation support.
     *   Use proxy mode; need to open code support;
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

    /**
     * Configure shiro redisManager
     * use shiro-redis open source plugin
     * @return
     */
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
        redisManager.setExpire(1800);// Configure the cache expiration time
        redisManager.setTimeout(timeout);
        // redisManager.setPassword(password);
        return redisManager;
    }

    /**
     * cacheManager cache
     * redis implementation
     * use shiro-redis open source plugin
     * @return
     */
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }


    /**
     * Achieve RedisSessionDAO shiro sessionDao layer through redis
     * Use shiro-redis open source plugin
     *
     */
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }

    /**
     * shiro session management 
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(redisSessionDAO());
        return sessionManager;
    }

}
