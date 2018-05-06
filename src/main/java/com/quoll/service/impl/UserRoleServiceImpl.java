package com.quoll.service.impl;

import com.quoll.mapper.UserRoleMapper;
import com.quoll.model.User;
import com.quoll.model.UserRole;
import com.quoll.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service("userRoleService")
public class UserRoleServiceImpl extends BaseService<UserRole> implements UserRoleService {
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void addUserRole(UserRole userRole) {
        //delete
        Example example = new Example(UserRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userid",userRole.getUserid());
        mapper.deleteByExample(example);
        //add
        String[] roleids = userRole.getRoleid().split(",");
        for (String roleId : roleids) {
            UserRole u = new UserRole();
            u.setUserid(userRole.getUserid());
            u.setRoleid(roleId);
            mapper.insert(u);
        }
    }

    @Override
    public List<User> findAllUsersByRoleDesc(String roleDesc){
        return userRoleMapper.findAllUsersByRoleDesc(roleDesc);
    }
}
