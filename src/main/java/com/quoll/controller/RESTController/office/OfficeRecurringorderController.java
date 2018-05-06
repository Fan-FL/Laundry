package com.quoll.controller.RESTController.office;

import com.github.pagehelper.PageInfo;
import com.quoll.model.Laundryorder;
import com.quoll.model.Recurringorder;
import com.quoll.service.*;
import com.quoll.util.Tools;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/office/recurringorder")
public class OfficeRecurringorderController {
    @Resource
    private RecurringorderService recurringorderService;

    @Resource
    private LaundryorderService orderService;

    @Autowired
    private Environment env;

    @RequestMapping("/getOne")
    @RequiresRoles("office")
    public Recurringorder getOne(Integer id) {
        return recurringorderService.selectByID(id);
    }

    @RequestMapping("/getAll")
    @RequiresRoles("office")
    public Map<String,Object> getAll(@RequestParam(required = false, defaultValue = "1") int start,
                                     @RequestParam(required = false, defaultValue = "10000") int length){
        Map<String,Object> map = new HashMap<>();
        PageInfo<Recurringorder> pageInfo = recurringorderService.selectByPage(start, length);
        map.put("recordsTotal",pageInfo.getTotal());
        map.put("recordsFiltered",pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    @RequestMapping("/update")
    @RequiresRoles("office")
    public String update(Recurringorder o) {
        try {
            recurringorderService.update(o);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/add")
    @RequiresRoles("office")
    public String add(Recurringorder o) {
        try {
            recurringorderService.insert(o);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/delete")
    @RequiresRoles("office")
    public String deleteByID(int id) {
        try {
            Recurringorder order = new Recurringorder();
            order.setId(id);
            order.setActive("0");
            recurringorderService.update(order);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/generateOrders")
    @RequiresRoles("office")
    public String generateOrders(int id) {
        try {
            Recurringorder recurringOrder = recurringorderService.selectByID(id);
            Date pickupDate = recurringOrder.getPickupdate();
            Date deliverDate = recurringOrder.getDeliverdate();
            while(pickupDate.before(recurringOrder.getEnddate())){
                Laundryorder laundryorder = new Laundryorder();
                laundryorder.setCompanyid(recurringOrder.getCompanyid());
                laundryorder.setPresetpickupdate(pickupDate);
                laundryorder.setPresetdeliverydate(deliverDate);
                laundryorder.setAddress(recurringOrder.getAddress());
                laundryorder.setStatus(Integer.parseInt(env.getProperty("order.status.created")));
                laundryorder.setStatushistory(env.getProperty("order.status.created") + ";");
                laundryorder.setRecurringflag(1);
                laundryorder.setCreateddate(Tools.getCurrentYMD());
                orderService.insert(laundryorder);
                pickupDate = Tools.addDays(pickupDate, recurringOrder.getIntervaldays());
                deliverDate = Tools.addDays(deliverDate, recurringOrder.getIntervaldays());
            }
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
}
