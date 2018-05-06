package com.quoll.shiro;

import com.quoll.model.*;
import com.quoll.service.ResourcesService;
import com.quoll.service.RoleService;
import com.quoll.service.UserRoleService;
import com.quoll.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private ResourcesService resourcesService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private RoleService roleService;

    //Certification
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //obtain the user's input account
        String username = (String)token.getPrincipal();
        if(null==username) throw new UnknownAccountException();
        if(null==token.getCredentials()) throw new UnknownAccountException();
        User user = userService.selectByUsername(username);
        if(user==null) throw new UnknownAccountException();
        if (0==user.getEnable()) {
            throw new LockedAccountException(); // account lock
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //username
                user.getPassword(), //password
                ByteSource.Util.bytes(username),
                getName()  //realm name
        );
        // When the validation is passed, the user information will put on the session
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("userSession", user);
        session.setAttribute("userSessionId", user.getId());
        Example example = new Example(UserRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userid", user.getId());
        List<UserRole> userRoles = userRoleService.selectByExample(example);
        if(!userRoles.isEmpty()){
            Role roles = roleService.selectByKey(Integer.valueOf(userRoles.get(0).getRoleid()));
            session.setAttribute("roleDesc", roles.getRoledesc());
        }
        return authenticationInfo;
    }

    //Authorization
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user= (User) SecurityUtils.getSubject().getPrincipal();//User{id=1, username='admin', password='3ef7164d1f6167cb9f2658c07d3c2f0a', enable=1}
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userid",user.getId());
        List<Resources> resourcesList = resourcesService.loadUserResources(map);
        // Authority information object info, used to store all the roles of the user and permission
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for(Resources resources: resourcesList){
            info.addStringPermission(resources.getResurl());
        }
        info.addRole((String) SecurityUtils.getSubject().getSession().getAttribute("roleDesc"));
        return info;
    }

}
