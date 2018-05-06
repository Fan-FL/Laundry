package com.quoll.controller.pageController;

import com.quoll.mapper.GarmentMapper;
import com.quoll.service.GarmentService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class DriverPageController {

    @Resource
    private GarmentService garmentService;

    @Resource
    private GarmentMapper garmentMapper;

    @RequestMapping("/driver/pickup")
    @RequiresRoles("driver")
    public String driverPickupPage(){
        return "driver_pickup";
    }

    @RequestMapping("/driver/pickup_todo")
    @RequiresRoles("driver")
    public ModelAndView driverPickupOrderPage(String orderid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( "driver_pickup_todo" );
        modelAndView.addObject( "orderid" , orderid);
        return modelAndView;
    }

    @RequestMapping("/driver/pickup_finished")
    @RequiresRoles("driver")
    public ModelAndView driverPickupOrderFinishedPage(String orderid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( "driver_pickup_finished" );
        modelAndView.addObject( "orderid" , orderid);
        return modelAndView;
    }

    @RequestMapping("/driver/dropoff")
    @RequiresRoles("driver")
    public String driverDropoffPage(){
        return "driver_dropoff";
    }

    @RequestMapping("/driver/dropoff_todo")
    @RequiresRoles("driver")
    public ModelAndView driverDropoffOrderTodoPage(String orderid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( "driver_dropoff_todo" );
        modelAndView.addObject( "orderid" , orderid);
        return modelAndView;
    }

    @RequestMapping("/driver/dropoff_finished")
    @RequiresRoles("driver")
    public ModelAndView driverDropoffOrderFinishedPage(String orderid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( "driver_dropoff_finished" );
        modelAndView.addObject( "orderid" , orderid);
        return modelAndView;
    }
}
