package com.quoll.controller.RESTController.admin;

import com.github.pagehelper.PageInfo;
import com.quoll.model.Role;
import com.quoll.model.RoleResources;
import com.quoll.service.RoleResourcesService;
import com.quoll.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Resource
    private RoleService roleService;
    @Resource
    private RoleResourcesService roleResourcesService;

    @RequestMapping
    @RequiresRoles("admin")
    public  Map<String,Object> getAll(Role role, String draw,
                                      @RequestParam(required = false, defaultValue = "1") int start,
                                      @RequestParam(required = false, defaultValue = "10") int length){

        Map<String,Object> map = new HashMap<>();
        PageInfo<Role> pageInfo = roleService.selectByPage(role, start, length);
        map.put("draw",draw);
        map.put("recordsTotal",pageInfo.getTotal());
        map.put("recordsFiltered",pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    @RequestMapping("/rolesWithSelected")
    @RequiresRoles("admin")
    public List<Role> rolesWithSelected(Integer uid){
        return roleService.queryRoleListWithSelected(uid);
    }

    //assigning roles
    @RequestMapping("/saveRoleResources")
    @RequiresRoles("admin")
    public String saveRoleResources(RoleResources roleResources){
        if(StringUtils.isEmpty(roleResources.getRoleid()))
            return "error";
        try {
            roleResourcesService.addRoleResources(roleResources);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/add")
    @RequiresRoles("admin")
    public String add(Role role) {
        try {
            roleService.save(role);
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
            roleService.delRole(id);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

}
