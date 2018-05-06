package com.quoll.mapper;


import com.quoll.model.Role;
import com.quoll.util.MyMapper;

import java.util.List;

public interface RoleMapper extends MyMapper<Role> {
    public List<Role> queryRoleListWithSelected(Integer id);
}