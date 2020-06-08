package com.welab.edda.controller;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyController {

    @GetMapping(path="/customers/{customer}")
    public ResponseEntity<Map<String, String>> getCustomer(@PathVariable("customer") String customer){
        System.out.println("get a my controller request"+customer);
        Map<String, String> map = new HashMap<>();
        map.put("1", customer);
        return new ResponseEntity(map,null, HttpStatus.OK);
    }

}
