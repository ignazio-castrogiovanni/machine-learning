package com.castrosoft.machinelearning.controller;

import com.castrosoft.machinelearning.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ignazio Castrogiovanni on 29/7/17.
 */
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
@RestController
@EnableAutoConfiguration
public class HealthController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/")
    public String hello() {
        return helloService.getAwkwardGreeting();
    }
}
