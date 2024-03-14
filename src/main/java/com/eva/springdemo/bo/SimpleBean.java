package com.eva.springdemo.bo;

import org.springframework.stereotype.Component;

@Component
//Simple tool bean to be autowired and tested.
public class SimpleBean {

    SimpleBean() {
        System.out.println("Simple bean construct!");
    }
}
