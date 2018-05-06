package com.quoll.service;

import com.github.pagehelper.PageInfo;
import com.quoll.model.Role;

import java.util.List;

public interface RoleService extends IService<Role> {

    public List<Role> queryRoleListWithSelected(Integer uid);

    PageInfo<Role> selectByPage(Role role, int start, int length);

    /**
     * Delete role - simultaneously delete the data in the role resource table
     * @param roleid
     */
    public void delRole(Integer roleid);

    public Role selectByDesc(String desc);
}
