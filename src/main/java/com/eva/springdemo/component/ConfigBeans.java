package com.eva.springdemo.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration(proxyBeanMethods = false)
public class ConfigBeans {

    //This will override the component annotation on DemoService.class
    //BeanDefinition 的类型会从 ScannedGenericBeanDefinition 被替换成 ConfigurationClassBeanDefinition
    @Bean(initMethod = "testInitMethod")
    @Lazy
    //当获取时才会第一次实例化这个bean。
    public DemoService demoService(){
        return new DemoService("kk");
    }
}
