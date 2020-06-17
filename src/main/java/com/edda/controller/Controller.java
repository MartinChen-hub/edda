package com.edda.controller;

import com.edda.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class Controller {

    private TestService testService;

    @Autowired
    public Controller(TestService testService){
        this.testService = testService;
    }

    @GetMapping(path="/test/customers/{customerId}")
    public String getCustomer(@PathVariable String customerId){
        log.info("get a controller request:{}", customerId);
        String t24CustomerId = testService.getCustomer(customerId);
        return t24CustomerId;
    }

    @PostMapping(path="/test/customers/{customerId}")
    public String createCustomer(@PathVariable String customerId){
        log.info("create a controller request:{}", customerId);
        String t24CustomerId = testService.getCustomer(customerId);
        return t24CustomerId;
    }
}
