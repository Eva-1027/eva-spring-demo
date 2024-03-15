package com.eva.springdemo.bo;

import com.eva.springdemo.component.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//Simple tool bean to be autowired and tested.
public class SimpleBean {

    SimpleBean() {
        System.out.println("Simple bean construct!");
    }
}
