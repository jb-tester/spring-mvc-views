package com.mytests.spring.springmvcviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * *
 * <p>Created by irina on 26.08.2020.</p>
 * <p>Project: spring-mvc-views</p>
 * *
 */
@Controller
@RequestMapping
public class ViewsResolveTestController {

    @Autowired
    private MyComponent myComponent;

    @RequestMapping("/test00")
    public ModelAndView test00(ModelAndView modelView) {
        String t00 = "aaa";
        modelView.setViewName("test00");
        modelView.addObject("test00_arg", t00);
        return modelView;
    }
    // view name as local variable used as ModelAndView constructor argument in method returning ModelAndView
    @RequestMapping(value = "/test02")
    public ModelAndView test02() {
        String viewName = "test02";  // not resolved as view name
        ModelAndView modelAndView = new ModelAndView(viewName);
        //ModelAndView modelAndView = new ModelAndView("test02");
        modelAndView.addObject("compo",myComponent.foo());
        //modelAndView.addObject("compo","foo");
        return modelAndView;
    }
    // view name as local variable used as return value in method returning String
    @RequestMapping("/test03")
    public String test03() {
        String viewname = "test03"; // not resolved as view name
        return viewname;
    }

    
    
    @RequestMapping(value = "/test01/foo")
    public ModelAndView test01() {

        return new ModelAndView("test01");
    }
    
     // redirect test:
    @RequestMapping("/test04")
    public String test04() {
        
        return "redirect:/test01/foo";
    }

     // redirect to mapping defined in SpringMvcViewsApplication.addViewControllers():
    
    @RequestMapping("/test07")
    public String test07() {
        
        return "redirect:/test0";
    }
    
    // redirect with pathvariables:
    
    @RequestMapping("/test10/{pv}")
    public ModelAndView test10(@PathVariable String pv, ModelAndView mav){
        mav.addObject("test10_attr",pv);
        mav.setViewName("test10");
        return mav;
    }
    
    @GetMapping("/test11/{pv}")
    public String test11(){
        return "redirect:/test10/{pv}";
    }
    
     // forwarding
    
    @GetMapping("/test08")
    public ModelAndView test08() {
        System.out.println("test08");
        ModelAndView modelAndView = new ModelAndView("forward:/test09");
        modelAndView.addObject("test8_attr","from test08");
        return modelAndView;
    }
    @RequestMapping("/test09")
    public String test09(Model model) {
        model.addAttribute("test9_attr", "from test09");
          return "test09";
    }
    
}

