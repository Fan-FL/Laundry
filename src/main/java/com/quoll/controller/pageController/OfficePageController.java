package com.quoll.controller.pageController;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class OfficePageController {

    @RequestMapping("/office/view_customers")
    @RequiresRoles("office")
    public String viewCustomersPage(){
        return "view_customers";
    }

    @RequestMapping("/office/view_order_detail")
    @RequiresRoles("office")
    public String viewOrderDetailPage(){
        return "view_order_detail";
    }

    @RequestMapping("/office/view_orders")
    @RequiresRoles("office")
    public String viewOrdersPage(){
        return "view_orders";
    }

    @RequestMapping("/office/add_new_customer")
    @RequiresRoles("office")
    public String addNewCustomerPage(){
        return "add_new_customer";
    }

    @RequestMapping("/office/add_nonrecurring_orders")
    @RequiresRoles("office")
    public String addNonrecurringOrdersPage(){
        return "add_nonrecurring_orders";
    }

    @RequestMapping("/office/manage_recurring_orders")
    @RequiresRoles("office")
    public String manageRecurringOrdersPage(){
        return "manage_recurring_orders";
    }

    @RequestMapping("/office/monthly_report")
    @RequiresRoles("office")
    public String monthlyReportPage(){
        return "monthly_report";
    }

    @RequestMapping("/office/view_customer_detail")
    @RequiresRoles("office")
    public ModelAndView customerDetailPage(String companyid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( "view_customer_detail" );
        modelAndView.addObject( "companyid" , companyid);
        return modelAndView;
    }
}
