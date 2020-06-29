package com.edda.controller;

import com.edda.proxy.CustomerProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerProxy customerProxy;

    public CustomerController(CustomerProxy customerProxy){
        this.customerProxy = customerProxy;
    }

//    @GetMapping(path = "/customer")
//    public ResponseEntity<String> customer(@RequestParam("id") String id) {
//        System.out.println("get==>"+id);
//
//        return new ResponseEntity<>("getCustomerInfo",null, HttpStatus.OK);
//    }
//
//    @PutMapping(path = {"/customer"})
//    public ResponseEntity<String> putCustomer(){
//        System.out.println("put");
//
//        return new ResponseEntity<>("put",null, HttpStatus.OK);
//    }
//
//    @PostMapping(path = {"/customer"})
//    public ResponseEntity<String> postCustomer(@RequestParam("name") String name,@RequestParam("password") String password){
//        System.out.println("post==>"+name+", password="+password);
//        Map map = new HashMap();
//        map.put("result","success");
//        return new ResponseEntity<>("post", null, HttpStatus.OK);
//    }

//    @PostMapping(path = {"/customer/{name}"})
//    public ResponseEntity<Map<String ,String>> postCustomer(@PathVariable("name") String name){
//        System.out.println("post==>"+name);
//        Map<String ,String> map = new HashMap<>();
//        map.put("result","success");
//        return new ResponseEntity(map, null, HttpStatus.OK);
//    }

    @GetMapping(path="/{customer}")
    public ResponseEntity<Map<String, String>> getCustomer(@PathVariable("customer") String customer){
        System.out.println("get a my controller request"+customer);
        Map<String, String> map = new HashMap<>();
        map.put("1", customer);
        return new ResponseEntity(map,null, HttpStatus.OK);
    }

    @GetMapping(path = {"/{customerId}/name"})
    public ResponseEntity getCustomerName(@PathVariable("customerId") String customerId){
        log.info("receive a request to edda controller to get customer name {}", customerId);
        String customerName = customerProxy.getCustomerName(customerId);
        return new ResponseEntity(customerName, null, HttpStatus.OK);
    }
}
