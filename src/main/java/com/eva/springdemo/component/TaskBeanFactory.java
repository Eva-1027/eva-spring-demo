package com.eva.springdemo.component;

import com.eva.springdemo.bo.Task;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
//是一个接口，用于生成bean。
public class TaskBeanFactory implements FactoryBean<Task> {
    @Override
    public Task getObject() throws Exception {
        return new Task("test", "testService");
    }

    @Override
    public Class<?> getObjectType() {
        return Task.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
