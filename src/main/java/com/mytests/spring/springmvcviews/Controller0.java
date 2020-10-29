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

    public static final String TEST_10 = "test10";
    @Autowired
    private MyComponent myComponent;

    // view name as local variable used as ModelAndView constructor argument in method returning ModelAndView
    @RequestMapping(value = "/test02")
    public ModelAndView test02() {

        String viewName = "test02";
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject("compo",myComponent.foo());
        //modelAndView.addObject("compo","foo");
        return modelAndView;
    }
    // view name as local variable used as return value in method returning String
    @RequestMapping("/test03")
    public String test03() {
        String viewname = "test03";
        return viewname;
    }

    
    
    @RequestMapping(value = "/test01/foo")
    public ModelAndView test01() {

        return new ModelAndView("test01");
    }

    // multiple urls using same path var
    @RequestMapping({"/test05/p1/{foo}/bar/{foo}}","/test05/p2/{foo}"})
    public String test05(@PathVariable String foo) {
        System.out.println(foo);
        return "test05";
    }
    // url using ant-style patterns
    @GetMapping(path="/test06/foo*/???-bar")
    public String test06() {

        return "test06";
    }

    // redirects
    @RequestMapping("/test04")
    public String test04() {

        return "redirect:/test01/foo";
    }

    @RequestMapping("/test07")
    public String test07() {
        
        return "redirect:/test0";
    }
    // view name as method return statement
    @GetMapping("/test08")
    public String test08() {

        return myComponent.getViewNameForTest08();
    }
    @RequestMapping("/test09")
    public String test09() {

          return getViewNameForTest09();
    }

    // view name as constant
    @RequestMapping("/test10")
    public String test10() {

        return TEST_10;
    }
    @RequestMapping("/test11")
    public String test11() {

        return "test"+"10";
    }

    public String getViewNameForTest09(){
        return "test09";
    }
}

