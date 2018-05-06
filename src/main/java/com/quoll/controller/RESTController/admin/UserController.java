package com.quoll.controller.RESTController.admin;

import com.github.pagehelper.PageInfo;
import com.quoll.model.User;
import com.quoll.model.UserRole;
import com.quoll.service.UserRoleService;
import com.quoll.util.PasswordHelper;
import com.quoll.service.UserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private UserRoleService userRoleService;

    @RequestMapping
    @RequiresRoles("admin")
    public Map<String,Object> getAll(User user, String draw,
                                     @RequestParam(required = false, defaultValue = "1") int start,
                                     @RequestParam(required = false, defaultValue = "10") int length){
        Map<String,Object> map = new HashMap<>();
        PageInfo<User> pageInfo = userService.selectByPage(user, start, length);
        System.out.println("pageInfo.getTotal():"+pageInfo.getTotal());
        map.put("draw",draw);
        map.put("recordsTotal",pageInfo.getTotal());
        map.put("recordsFiltered",pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }


    /**
     * Save the user role
     * @param userRole 
     * The character id of the parameter obtained by a string that is separated by “,” 
     * @return
     */
    @RequestMapping("/saveUserRoles")
    @RequiresRoles("admin")
    public String saveUserRoles(UserRole userRole){
        if(StringUtils.isEmpty(userRole.getUserid()))
            return "error";
        try {
            userRoleService.addUserRole(userRole);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/add")
    @RequiresRoles("admin")
    public String add(User user) {
        User u = userService.selectByUsername(user.getUsername());
        if(u != null)
            return "error";
        try {
            user.setEnable(1);
            PasswordHelper passwordHelper = new PasswordHelper();
            passwordHelper.encryptPassword(user);
            userService.save(user);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/delete")
    @RequiresRoles("admin")
    public String delete(Integer id){
      try{
          userService.delUser(id);
          return "success";
      }catch (Exception e){
          e.printStackTrace();
          return "fail";
      }
    }

}
