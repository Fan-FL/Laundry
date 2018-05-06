package com.quoll.controller.RESTController.packing;

import com.github.pagehelper.PageInfo;
import com.quoll.model.Laundryorder;
import com.quoll.model.Orderitems;
import com.quoll.model.OrderitemsKey;
import com.quoll.service.LaundryorderService;
import com.quoll.service.OrderitemsService;
import com.quoll.util.Tools;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/packing/order")
public class PackingOrderController {
    @Resource
    private LaundryorderService orderService;

    @Resource
    private OrderitemsService orderitemsService;

    @Autowired
    private Environment env;

    @RequestMapping("/getAllUnpacked")
    @RequiresRoles("packing")
    public List<Laundryorder> getAllUnpacked(@RequestParam(required = false, defaultValue = "1") int start,
                                      @RequestParam(required = false, defaultValue = "100") int length) {
        try{
            Laundryorder laundryorder = new Laundryorder();
            laundryorder.setPackingpersonid((Integer) SecurityUtils.getSubject().getSession().getAttribute("userSessionId"));
            laundryorder.setStatus(Integer.parseInt(env.getProperty("order.status.pickedup")));
            List<Laundryorder> unpackedList = orderService.selectRefSelective(laundryorder);
            for (Laundryorder order:unpackedList) {
                order.setItemsDescription(orderService.getItemsDescriptionByID(order.getId()));
            }
            return unpackedList;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("/getAllPartially")
    @RequiresRoles("packing")
    public List<Laundryorder> getAllPartially(@RequestParam(required = false, defaultValue = "1") int start,
                                      @RequestParam(required = false, defaultValue = "100") int length) {
        try{
            Laundryorder laundryorder = new Laundryorder();
            laundryorder.setPackingpersonid((Integer) SecurityUtils.getSubject().getSession().getAttribute("userSessionId"));
            laundryorder.setStatus(Integer.parseInt(env.getProperty("order.status.partially_packed")));
            List<Laundryorder> partiallyList = orderService.selectRefSelective(laundryorder);
            for (Laundryorder order:partiallyList) {
                order.setItemsDescription(orderService.getItemsDescriptionByID(order.getId()));
            }
            return partiallyList;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("/getAllPacked")
    @RequiresRoles("packing")
    public Map<String,Object> getAllPacked(@RequestParam(required = false, defaultValue = "1") int start,
                                      @RequestParam(required = false, defaultValue = "100") int length) {
        try {
            Map<String,Object> map = new HashMap<>();
            Laundryorder laundryorder = new Laundryorder();
            laundryorder.setPackingpersonid((Integer) SecurityUtils.getSubject().getSession().getAttribute("userSessionId"));
            laundryorder.setStatusLittleEnd(Integer.parseInt(env.getProperty("order.status.packed")));
            PageInfo<Laundryorder> pageInfo = orderService.selectRefStatusBetweenSelectiveByPage(laundryorder, start, length);
            List<Laundryorder> orders = pageInfo.getList();
            for (Laundryorder order:orders) {
                order.setItemsDescription(orderService.getItemsDescriptionByID(order.getId()));
            }
            map.put("recordsTotal",pageInfo.getTotal());
            map.put("recordsFiltered",pageInfo.getTotal());
            map.put("data", orders);
            return map;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/getOrderDetail")
    @RequiresRoles("packing")
    public Map<String, Object> getOrderDetail(int orderid) {
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

    @RequestMapping("/submitOrder")
    @RequiresRoles("packing")
    public String submitPackingOrder(@RequestBody Laundryorder order) {
        try{
            boolean isFinished = true;
            for (Orderitems item :order.getOrderitemsList()) {
                OrderitemsKey orderitemsKey = new OrderitemsKey();
                orderitemsKey.setOrderid(order.getId());
                orderitemsKey.setGarmentid(item.getGarmentid());
                Orderitems databaseItem = orderitemsService.selectByPrimaryKey(orderitemsKey);
                if(databaseItem.getPickupnumber().intValue() != item.getPacknumber().intValue()){
                    isFinished = false;
                }
                item.setOrderid(order.getId());
                orderitemsService.update(item);
            }
            if(isFinished){
                order.setStatus(Integer.parseInt(env.getProperty("order.status.packed")));
                order.setStatushistory(orderService.selectByID(order.getId()).getStatushistory()+env.getProperty("order.status.packed")+";");
                order.setPackingdate(Tools.getCurrentYMD());
            }else{
                order.setStatus(Integer.parseInt(env.getProperty("order.status.partially_packed")));
                order.setStatushistory(orderService.selectByID(order.getId()).getStatushistory()+env.getProperty("order.status.partially_packed")+";");
            }
            orderService.update(order);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/forceToPacked")
    @RequiresRoles("packing")
    public String forceToPacked(@RequestBody Laundryorder order) {
        try{
            for (Orderitems item :order.getOrderitemsList()) {
                item.setOrderid(order.getId());
                orderitemsService.update(item);
            }
            order.setStatus(Integer.parseInt(env.getProperty("order.status.packed")));
            order.setStatushistory(orderService.selectByID(order.getId()).getStatushistory()+env.getProperty("order.status.packed")+";");
            order.setPackingdate(Tools.getCurrentYMD());
            orderService.update(order);
            return "success";
        }catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }

    }

}