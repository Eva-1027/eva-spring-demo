package com.eva.springdemo.component;

import com.eva.springdemo.aspect.Encryption;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AopService {

    AopService() {
        System.out.println("Aop lazy init? " + this.getClass());
    }


    @Transactional
    public void testAopLazyInit() {
        System.out.println("Lazy init test!");
    }
}
