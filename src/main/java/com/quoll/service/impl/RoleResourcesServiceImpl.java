package com.quoll.service.impl;

import com.quoll.model.RoleResources;
import com.quoll.service.RoleResourcesService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

@Service("roleResourcesService")
public class RoleResourcesServiceImpl extends BaseService<RoleResources> implements RoleResourcesService {
   /* @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private ShiroService shiroService;*/


    @Override
    //Update permissions
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    @CacheEvict(cacheNames="resources", allEntries=true)
    public void addRoleResources(RoleResources roleResources) {
        //delete
        Example example = new Example(RoleResources.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleid",roleResources.getRoleid());
        mapper.deleteByExample(example);
        //add
        if(!StringUtils.isEmpty(roleResources.getResourcesid())){
            String[] resourcesArr = roleResources.getResourcesid().split(",");
            for(String resourcesId:resourcesArr ){
                RoleResources r = new RoleResources();
                r.setRoleid(roleResources.getRoleid());
                r.setResourcesid(resourcesId);
                mapper.insert(r);
            }
        }

        //List<Integer> userIds= userRoleMapper.findUserIdByRoleId(roleResources.getRoleid());
        //Update the permissions of the currently logged-in user's cache
        //shiroService.clearUserAuthByUserId(userIds);
    }
}
