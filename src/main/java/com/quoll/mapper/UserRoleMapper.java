package com.quoll.mapper;


import com.quoll.model.User;
import com.quoll.model.UserRole;
import com.quoll.util.MyMapper;

import java.util.List;

public interface UserRoleMapper extends MyMapper<UserRole> {
    public List<Integer> findUserIdByRoleId(Integer roleId);

    public List<User> findAllUsersByRoleDesc(String roleDesc);
}