package com.eva.springdemo.bo;

import org.springframework.beans.factory.InitializingBean;

public class PlainClass implements InitializingBean {

    public PlainClass() {
        System.out.println("Plain class construct!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("!!!Pay attention, I'm the after properties set in plain class!!!");
    }
}
