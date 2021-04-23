package com.mytests.spring.springmvcviews;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * *
 * <p>Created by irina on 23.04.2021.</p>
 * <p>Project: spring-mvc-views</p>
 * *
 */
@Controller
public class PathVarsAndWildcardsTestController {

    @RequestMapping({"/test05/p1/{foo}/bar/{foo}}","/test05/p2/{foo}"})
    public String test05(@PathVariable String foo) {
        System.out.println(foo);
        return "test05";
    }

    @GetMapping(path="/test06/foo*/???-bar") // not processed correctly by Endpoints and HTTP Client; also find usages 
    public String test06() {

        return "test06";
    }
}
