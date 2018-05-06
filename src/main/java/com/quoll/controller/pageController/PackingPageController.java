package com.quoll.controller.pageController;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PackingPageController {

    @RequestMapping("/packing/unpacked_all")
    @RequiresRoles("packing")
    public String unpackedPage(){
        return "packing_unpacked_all";
    }

    @RequestMapping("/packing/partially_all")
    @RequiresRoles("packing")
    public String partiallyPage(){
        return "packing_partially_all";
    }

    @RequestMapping("/packing/packed_all")
    @RequiresRoles("packing")
    public String finishedPage(){
        return "packing_packed_all";
    }

    @RequestMapping("/packing/unpacked")
    @RequiresRoles("packing")
    public ModelAndView packingCurrentTodoOrderPage(String orderid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( "packing_unpacked" );
        modelAndView.addObject( "orderid" , orderid);
        return modelAndView;
    }

    @RequestMapping("/packing/partially")
    @RequiresRoles("packing")
    public ModelAndView packingPage(String orderid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( "packing_partially" );
        modelAndView.addObject( "orderid" , orderid);
        return modelAndView;
    }


    @RequestMapping("/packing/packed")
    @RequiresRoles("packing")
    public ModelAndView packingFinishedPage(String orderid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( "packing_packed" );
        modelAndView.addObject( "orderid" , orderid);
        return modelAndView;
    }
}
