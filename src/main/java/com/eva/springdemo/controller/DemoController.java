package com.eva.springdemo.controller;

import com.eva.springdemo.aspect.Encryption;
import com.eva.springdemo.component.AopService;
import com.eva.springdemo.component.ApplicationAwareService;
import com.eva.springdemo.component.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Please use rest controller instead of controller.
// since rest controller is the combination of controller and response body.
public class DemoController {

    @Autowired
    private DemoService service;

    @GetMapping("/aop/{workingHard}")
    @Encryption("I think this is basic.")
    public String testEncryption(@PathVariable("workingHard") boolean workingHard) {

        return "";
    }
}
