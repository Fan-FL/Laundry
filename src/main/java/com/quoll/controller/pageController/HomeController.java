package com.quoll.controller.pageController;

import com.quoll.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(HttpServletRequest request, User user, Model model){
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            request.setAttribute("msg", "The user name or password can not be empty！");
            return "login";
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            subject.login(token);
            return "redirect:/moduleNavigation";
        }catch (LockedAccountException lae) {
            token.clear();
            request.setAttribute("msg", "The user has been locked and can not log in. Please contact the administrator！");
            return "login";
        } catch (AuthenticationException e) {
            token.clear();
            request.setAttribute("msg", "The user or password is incorrect！");
            return "login";
        }
    }

    @RequestMapping("/usersPage")
    @RequiresRoles("admin")
    public String usersPage(){
        return "user/users";
    }

    @RequestMapping("/rolesPage")
    @RequiresRoles("admin")
    public String rolesPage(){
        return "role/roles";
    }

    @RequestMapping("/resourcesPage")
    @RequiresRoles("admin")
    public String resourcesPage(){
        return "resources/resources";
    }

    @RequestMapping(value={"/moduleNavigation",""})
    public String moduleNavigation(){
        String roleDesc = (String) SecurityUtils.getSubject().getSession().getAttribute("roleDesc");
        System.out.println(roleDesc);
        switch (roleDesc) {
            case "driver": {
                return "redirect:/driver/pickup";
            }
            case "office": {
                return "redirect:/office/view_orders";
            }
            case "packing": {
                return "redirect:/packing/unpacked_all";
            }
            default:{
                return "redirect:/usersPage";
            }
        }
    }
}
