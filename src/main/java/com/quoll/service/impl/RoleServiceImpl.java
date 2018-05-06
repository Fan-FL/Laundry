package com.quoll.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.quoll.mapper.RoleMapper;
import com.quoll.mapper.RoleResourcesMapper;
import com.quoll.model.Role;
import com.quoll.model.RoleResources;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quoll.service.RoleService;
import tk.mybatis.mapper.entity.Example;

@Service("roleService")
public class RoleServiceImpl extends BaseService<Role> implements RoleService{

    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RoleResourcesMapper roleResourcesMapper;

    @Override
    public List<Role> queryRoleListWithSelected(Integer uid) {
        return roleMapper.queryRoleListWithSelected(uid);
    }

    @Override
    public PageInfo<Role> selectByPage(Role role, int start, int length) {
        int page = start/length+1;
        Example example = new Example(Role.class);
        //paging query
        PageHelper.startPage(page, length);
        List<Role> rolesList = selectByExample(example);
        return new PageInfo<>(rolesList);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void delRole(Integer roleid) {
        //delete role
        mapper.deleteByPrimaryKey(roleid);
        //delete role resource
        Example example = new Example(RoleResources.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleid",roleid);
        roleResourcesMapper.deleteByExample(example);
    }

    @Override
    public Role selectByDesc(String desc){
        Example example = new Example(Role.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleDesc",desc);
        return roleMapper.selectByExample(example).get(0);
    }
}
