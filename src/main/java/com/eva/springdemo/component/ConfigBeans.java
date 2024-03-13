package com.eva.springdemo.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class ConfigBeans {

    //This will override the component annotation on DemoService.class
    @Bean(initMethod = "testInitMethod")
    public DemoService demoService(){
        return new DemoService("kk");
    }
}
