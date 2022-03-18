package com.mytests.spring.springmvcviews;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * *
 * <p>Created by irina on 23.04.2021.</p>
 * <p>Project: spring-mvc-views</p>
 * *
 */
public class ViewResolveComplexTestController {
    public static final String TEST_12 = "test12";
    
    // view name as method return value
    @RequestMapping("/test12_1")
    public String test12_1() {

        return getViewNameForTest12_1();
    }

    // view name as constant
    @RequestMapping("/test12_2")
    public String test12_2() {

        return TEST_12;
    }
    
    // view name as concatenation
    @RequestMapping("/test12_3")
    public String test11() {

        return "test"+"12";
    }

    public String getViewNameForTest12_1(){
        return "test12";
    }
}
