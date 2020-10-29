package com.mytests.spring.springmvcviews;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * *
 * <p>Created by irina on 29.10.2020.</p>
 * <p>Project: spring-mvc-views</p>
 * *
 */
@Component("myComponent")
public class MyComponent {

    //@Value("myComponent")
    public static String id="foo";


    public String foo() {
        return MyComponent.id;
    }

    public String getViewNameForTest08(){
        return "test08";
    }

}
