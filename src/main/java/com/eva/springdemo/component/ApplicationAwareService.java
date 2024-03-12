package com.eva.springdemo.component;

import com.eva.springdemo.bo.Task;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class ApplicationAwareService implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Task task1 = applicationContext.getBean(Task.class);
        System.out.println(task1.toString());

        Task task2 = applicationContext.getBean(Task.class);
        System.out.println(task2.toString());
    }
}
