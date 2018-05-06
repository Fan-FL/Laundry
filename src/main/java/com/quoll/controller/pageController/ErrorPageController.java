package com.quoll.controller.pageController;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error")
@EnableConfigurationProperties({ServerProperties.class})
public class ErrorPageController implements ErrorController {

    /**
     * 404 page
     *
     */
    @RequestMapping(produces = "text/html", value = "404")
    public ModelAndView errorHtml404() {
        return new ModelAndView("error/404");
    }

    /**
     * 400 page
     *
     */
    @RequestMapping(produces = "text/html", value = "401")
    public ModelAndView errorHtml401() {
        return new ModelAndView("error/401");
    }

    /**
     * 500 page
     *
     */
    @RequestMapping(produces = "text/html", value = "500")
    public ModelAndView errorHtml500() {
        return new ModelAndView("error/500");
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
