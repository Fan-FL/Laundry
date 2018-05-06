package com.quoll.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "user_role")
public class UserRole implements Serializable{
    private static final long serialVersionUID = -916411139749530670L;
    @Column(name = "userId")
    private Integer userid;

    @Column(name = "roleId")
    private String roleid;

    @Transient
    private User user;

    @Transient
    private Role role;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * @return userId
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }
}