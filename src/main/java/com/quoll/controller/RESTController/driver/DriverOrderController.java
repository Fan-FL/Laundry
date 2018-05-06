package com.quoll.controller.RESTController.driver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quoll.model.*;
import com.quoll.service.CompanyService;
import com.quoll.service.LaundryorderService;
import com.quoll.service.OrderitemsService;
import com.quoll.util.Tools;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/driver/order")
public class DriverOrderController {
    @Resource
    private LaundryorderService orderService;

    @Resource
    private OrderitemsService orderitemsService;

    @Resource
    private CompanyService companyService;

    @Autowired
    private Environment env;

    @RequestMapping("/getOne")
    @RequiresRoles("driver")
    public Laundryorder getOne(Integer id) {
        return orderService.selectByID(id);
    }

    @RequestMapping("/getAllPickup")
    @RequiresRoles("driver")
    public Map<String, Object> getAllPickup(String presetpickupdate,
                                      @RequestParam(required = false, defaultValue = "1") int start,
                                      @RequestParam(required = false, defaultValue = "10000") int length){
        try {
            Map<String, Object> map = new HashMap<>();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date date = sdf.parse(presetpickupdate);
            Laundryorder laundryorder = new Laundryorder();
            laundryorder.setPresetpickupdate(date);
            laundryorder.setDriverid((Integer) SecurityUtils.getSubject().getSession().getAttribute("userSessionId"));
            laundryorder.setStatus(Integer.parseInt(env.getProperty("order.status.created")));
            List<Laundryorder> todo = orderService.selectRefSelective(laundryorder);
            map.put("todo", todo);

            Laundryorder laundryorder2 = new Laundryorder();
            laundryorder2.setPresetpickupdate(date);
            laundryorder2.setDriverid((Integer) SecurityUtils.getSubject().getSession().getAttribute("userSessionId"));
            laundryorder2.setStatusLittleEnd(Integer.parseInt(env.getProperty("order.status.pickedup")));
            List<Laundryorder> finished = orderService.selectRefStatusBetweenSelective(laundryorder2);
            map.put("finished", finished);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/getAllDropoff")
    @RequiresRoles("driver")
    public Map<String, Object> getAllDropoff(String presetdeliverydate,
                                            @RequestParam(required = false, defaultValue = "1") int start,
                                            @RequestParam(required = false, defaultValue = "10000") int length){
        try {
            Map<String, Object> map = new HashMap<>();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date date = sdf.parse(presetdeliverydate);
            Laundryorder laundryorder = new Laundryorder();
            laundryorder.setPresetdeliverydate(date);
            laundryorder.setDeliverydriverid((Integer) SecurityUtils.getSubject().getSession().getAttribute("userSessionId"));
            laundryorder.setStatus(Integer.parseInt(env.getProperty("order.status.packed")));
            List<Laundryorder> todo = orderService.selectRefSelective(laundryorder);
            map.put("todo", todo);

            Laundryorder laundryorder2 = new Laundryorder();
            laundryorder2.setPresetdeliverydate(date);
            laundryorder2.setDeliverydriverid((Integer) SecurityUtils.getSubject().getSession().getAttribute("userSessionId"));
            laundryorder2.setStatusLittleEnd(Integer.parseInt(env.getProperty("order.status.delivered")));
            List<Laundryorder> finished = orderService.selectRefStatusBetweenSelective(laundryorder2);
            map.put("finished", finished);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/updateOrder")
    @RequiresRoles("driver")
    public String updateOrder(Laundryorder o) {
        try {
            orderService.update(o);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/pickup_submit")
    @RequiresRoles("driver")
    public String pickupSubmit(@RequestBody Map<String,Object> listMap) {
        try {
            System.out.println(listMap);
            JSONObject jsonObject = new JSONObject(listMap);
            Integer orderid = Integer.parseInt((String)jsonObject.get("orderid"));
            String notes = (String) jsonObject.get("notes");
            String itemsString = ((JSONArray) jsonObject.get("items")).toString();
            ObjectMapper mapper = new ObjectMapper();
            List<Orderitems> items = null;items = mapper.readValue(itemsString, new TypeReference<List<Orderitems>>() {});
            for (Orderitems o : items) {
                if(o.getPickupnumber () >0){
                  o.setOrderid(orderid);
                  orderitemsService.insert(o);
                }
            }
            Laundryorder laundryorder = new Laundryorder();
            laundryorder.setId(orderid);
            if (!notes.isEmpty()){
                laundryorder.setNotes(notes);
            }
            laundryorder.setRealpickupdate(Tools.getCurrentYMD());
            laundryorder.setStatus(Integer.parseInt(env.getProperty("order.status.pickedup")));
            laundryorder.setStatushistory(orderService.selectByID(orderid).getStatushistory()+env.getProperty("order.status.pickedup")+";");
            orderService.update(laundryorder);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/pickup_todo")
    @RequiresRoles("driver")
    public Map<String, Object> getPickupTodoOne(int orderid) {
        try {
            Map<String, Object> map = new HashMap<>();
            Laundryorder laundryorder = orderService.selectByID(orderid);
            map.put("address", laundryorder.getAddress());
            map.put("company", companyService.selectCompanyGarments(laundryorder.getCompanyid(),"1"));
            return map;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/pickup_finished")
    @RequiresRoles("driver")
    public Map<String, Object> getPickupFinishedOne(int orderid) {
        try {
            Map<String, Object> map = new HashMap<>();
            Laundryorder laundryorder = orderService.selectByID(orderid);
            map.put("order", laundryorder);
            map.put("items", orderitemsService.selectGarmentItemByOrderID(orderid));
            return map;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("/dropoff_submit")
    @RequiresRoles("driver")
    public String dropoffSubmit(int orderid) {
        try {
            Laundryorder laundryorder = new Laundryorder();
            laundryorder.setId(orderid);
            laundryorder.setDeliverydate(Tools.getCurrentYMD());
            laundryorder.setStatus(Integer.parseInt(env.getProperty("order.status.delivered")));
            laundryorder.setStatushistory(orderService.selectByID(orderid).getStatushistory()+env.getProperty("order.status.delivered")+";");
            orderService.update(laundryorder);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/dropoff_finished")
    @RequiresRoles("driver")
    public Map<String, Object> getDropoffFinishedOne(int orderid) {
        try{
            Map<String, Object> map = new HashMap<>();
            Laundryorder laundryorder = orderService.selectByID(orderid);
            map.put("order", laundryorder);
            map.put("items", orderitemsService.selectGarmentItemByOrderID(orderid));
            return map;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("/dropoff_todo")
    @RequiresRoles("driver")
    public Map<String, Object> getDropoffTodoOne(int orderid) {
        Map<String, Object> map = new HashMap<>();
        Laundryorder laundryorder = orderService.selectByID(orderid);
        map.put("order", laundryorder);
        map.put("items", orderitemsService.selectGarmentItemByOrderID(orderid));
        return map;
    }
}