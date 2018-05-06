package com.quoll.controller.RESTController.office;

import com.github.pagehelper.PageInfo;
import com.quoll.model.Garment;
import com.quoll.service.GarmentService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/office/garment")
public class GarmentController {
    @Resource
    private GarmentService garmentService;


    @RequestMapping("/selectByID")
    @RequiresRoles("office")
    public Garment selectOne(Integer id) {
        Garment o = garmentService.selectByID(id);
        return o;
    }

    @RequestMapping("/selectAll")
    @RequiresRoles("office")
    public Map<String,Object> getAll(@RequestParam(required = false, defaultValue = "1") int start,
                                     @RequestParam(required = false, defaultValue = "10000") int length){
        Map<String,Object> map = new HashMap<>();
        PageInfo<Garment> pageInfo = garmentService.selectByPage( start, length);
        System.out.println("pageInfo.getTotal():"+pageInfo.getTotal());
        map.put("recordsTotal",pageInfo.getTotal());
        map.put("recordsFiltered",pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    @RequestMapping("/update")
    @RequiresRoles("office")
    public int update(Garment o) {
        return garmentService.update(o);
    }

    @RequestMapping("/insert")
    @RequiresRoles("office")
    public int insert(Garment o) {
        return garmentService.insert(o);
    }

    @RequestMapping("/deleteByCompanyID")
    @RequiresRoles("office")
    public int deleteByCompanyID(int companyID) {
        return garmentService.inactiveByCompanyID(companyID);
    }



}
