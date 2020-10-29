package com.mytests.spring.springmvcviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * *
 * <p>Created by irina on 26.08.2020.</p>
 * <p>Project: spring-mvc-views</p>
 * *
 */
@Controller
@RequestMapping
public class Controller0 {

    @Autowired
    private MyComponent myComponent;

    @RequestMapping(value = "/test02")
    public ModelAndView test02() {

        String viewName = "test02";

        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject("compo",myComponent.foo());
        //modelAndView.addObject("compo","foo");
        return modelAndView;
    }
    @RequestMapping("/test03")
    public String test03() {
        String viewname = "test03";
        return viewname;
    }

    
    
    @RequestMapping(value = "/test01/foo")
    public ModelAndView test01() {

        return new ModelAndView("test01");
    }

    @RequestMapping("/test04")
    public String test04() {
        
        return "redirect:/test01/foo";
    }

    @RequestMapping({"/test05/p1/{foo}/bar/{foo}}","/test05/p2/{foo}"})
    public String test05(@PathVariable String foo) {
        System.out.println(foo);
        return "test05";
    }

    @GetMapping(path="/test06/foo*/???-bar")
    public String test06() {
        
        return "test06";
    }

    @RequestMapping("/test07")
    public String test07() {
        
        return "redirect:/test0";
    }
    
    /*@GetMapping("/test0")
    public String test08() {
        System.out.println("test08");
        return "test08";
    }
    @RequestMapping("/test0")
    public String test09() {
        System.out.println("test09");
          return "test09";
    }*/
}

