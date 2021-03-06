package com.mytests.spring.springmvcviews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringMvcViewsApplication implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/test0").setViewName("test0");
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcViewsApplication.class, args);
    }

}
