package com.eva.springdemo.component;

import com.eva.springdemo.bo.PlainClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration(proxyBeanMethods = false)
//Default is true, means when calling method in this class, the return bean will acquire from IOC container won't call the method in this class again.
//When false, means call the method in this config class directly without be proxied by CGLIB, will enhance performance.
public class ConfigBeans {

    //This will override the component annotation on DemoService.class
    //BeanDefinition 的类型会从 ScannedGenericBeanDefinition 被替换成 ConfigurationClassBeanDefinition
    @Bean(initMethod = "testInitMethod")
    @Lazy
    //当获取时才会第一次实例化这个bean。
    public DemoService demoService(){
        PlainClass plainClass = PlainClass();
        System.out.println("Call in other function in config class: " + plainClass.toString());
        return new DemoService("kk");
    }

    @Bean
    public PlainClass PlainClass() {
        System.out.println("Calling plain class method!");
        PlainClass plainClass = new PlainClass();
        System.out.println("Bean in IOC container: " + plainClass.toString());
        return plainClass;
    }
}
