package com.quoll.service;

import com.quoll.model.User;
import com.quoll.model.UserRole;

import java.util.List;

public interface UserRoleService extends IService<UserRole> {

    public void addUserRole(UserRole userRole);

    public List<User> findAllUsersByRoleDesc(String roleDesc);
}
