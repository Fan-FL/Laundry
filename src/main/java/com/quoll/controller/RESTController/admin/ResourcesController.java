package com.quoll.controller.RESTController.admin;

import com.github.pagehelper.PageInfo;
import com.quoll.model.Resources;
import com.quoll.service.ResourcesService;
import com.quoll.shiro.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/resources")
public class ResourcesController {

    @Resource
    private ResourcesService resourcesService;
    @Resource
    private ShiroService shiroService;

    @RequestMapping
    @RequiresRoles("admin")
    public Map<String,Object> getAll(Resources resources, String draw,
                                     @RequestParam(required = false, defaultValue = "1") int start,
                                     @RequestParam(required = false, defaultValue = "10") int length){
        Map<String,Object> map = new HashMap<>();
        PageInfo<Resources> pageInfo = resourcesService.selectByPage(resources, start, length);
        System.out.println("pageInfo.getTotal():"+pageInfo.getTotal());
        map.put("draw",draw);
        map.put("recordsTotal",pageInfo.getTotal());
        map.put("recordsFiltered",pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    @RequestMapping("/resourcesWithSelected")
    @RequiresRoles("admin")
    public List<Resources> resourcesWithSelected(Integer rid){
        return resourcesService.queryResourcesListWithSelected(rid);
    }

    @RequestMapping("/loadMenu")
    @RequiresRoles("admin")
    public List<Resources> loadMenu(){
        Map<String,Object> map = new HashMap<>();
        Integer userid = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userSessionId");
        map.put("type",1);
        map.put("userid",userid);
        List<Resources> resourcesList = resourcesService.loadUserResources(map);
        System.out.println();
        return resourcesList;
    }

    @CacheEvict(cacheNames="resources", allEntries=true)
    @RequestMapping(value = "/add")
    @RequiresRoles("admin")
    public String add(Resources resources){
        try{
            resourcesService.save(resources);
            //Update permissions
            shiroService.updatePermission();
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @CacheEvict(cacheNames="resources", allEntries=true)
    @RequestMapping(value = "/delete")
    @RequiresRoles("admin")
    public String delete(Integer id){
        try{
            resourcesService.delete(id);
            //Update permissions
            shiroService.updatePermission();
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @CacheEvict(cacheNames="resources", allEntries=true)
    @RequestMapping(value = "/modify")
    @RequiresRoles("admin")
    public String modify(Resources resources){
        try{
            resourcesService.updateAll(resources);
            //Update permissions
            shiroService.updatePermission();
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @CacheEvict(cacheNames="resources", allEntries=true)
    @RequestMapping(value = "/getOne")
    @RequiresRoles("admin")
    public Resources getOne(Integer id){
        try{
            Resources resources = resourcesService.selectByKey(id);
            return resources;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
