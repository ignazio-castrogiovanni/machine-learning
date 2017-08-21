package com.castrosoft.machinelearning.controller;

import com.castrosoft.machinelearning.service.HelloService;
import com.castrosoft.machinelearning.vo.GeneralJsonOutputVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/json")
    public ResponseEntity<?> helloJson() {
        GeneralJsonOutputVO output = new GeneralJsonOutputVO(helloService.getAwkwardGreeting());
        return new ResponseEntity<>(output, HttpStatus.OK);
    }
}
