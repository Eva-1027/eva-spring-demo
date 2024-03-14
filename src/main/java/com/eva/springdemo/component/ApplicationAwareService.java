package com.eva.springdemo.component;

import com.eva.springdemo.bo.Task;
import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationAwareService implements ApplicationContextAware {

    //@Autowired
    // !!!***When autowired this bean, the lazy annotation won't take effect.***!!!
    //private DemoService demoService;

    @Autowired
    private Task task;

    @Getter
    private static ApplicationContext awareServiceApplicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Task task1 = applicationContext.getBean(Task.class);
        System.out.println(task1.toString());

        Task task2 = applicationContext.getBean(Task.class);
        System.out.println(task2.toString());

        System.out.println(task.toString());

        awareServiceApplicationContext = applicationContext;
    }

}
