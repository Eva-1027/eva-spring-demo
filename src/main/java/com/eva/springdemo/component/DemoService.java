package com.eva.springdemo.component;

import com.eva.springdemo.bo.SimpleBean;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoService implements BeanNameAware, InitializingBean {

    @Autowired
    private SimpleBean simpleBean;

    @Override
    //In Initializing bean interface.
    public void afterPropertiesSet() throws Exception {
        System.out.println("After Properties set, name is : " + name);
    }

    DemoService() {
        System.out.println("No arg constructor!");
    }

    DemoService(String name) {
        System.out.println("Named arg constructor, name is : " + name);
        this.name = name;
    }

    private String name;

    @Override
    //In bean name aware interface.
    public void setBeanName(String name) {
        System.out.println("In bean name aware, the bean name is: " + name);
    }

    @PostConstruct
    //This annotation implements in commonAnnotationBeanPostProcessor.
    void init() {
        System.out.println("Calling post construct!");
        name = "Eva";
    }

    public String hello() {
        return "hello" + name;
    }

    public void testInitMethod(){
        System.out.println("Init-Method");
    }

}
