package com.eva.springdemo.component;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class DemoService implements BeanNameAware {
    private String name;

    @Override
    public void setBeanName(String name) {
        System.out.println("In bean name aware, the bean name is: " + name);
    }

    @PostConstruct
    void init() {
        System.out.println("Calling post construct!");
        name = "Eva";
    }

    public String hello() {
        return "hello" + name;
    }

}
