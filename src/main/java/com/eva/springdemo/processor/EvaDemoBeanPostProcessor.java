package com.eva.springdemo.processor;

import com.eva.springdemo.component.DemoService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EvaDemoBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof DemoService) {
            System.out.println("Bean name in after initialization: " + beanName);
            System.out.println("Final output name is: " + ((DemoService) bean).hello());
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof DemoService) {
            System.out.println("Bean name in before initialization: " + beanName);
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
