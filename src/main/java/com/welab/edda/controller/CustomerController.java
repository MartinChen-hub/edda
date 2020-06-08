package com.welab.edda.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("v1")
public class CustomerController {

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

    @PostMapping(path = {"/customer/{name}"})
    public ResponseEntity postCustomer(@PathVariable("name") String name){
        System.out.println("post==>"+name);
        Map<String,String> map = new HashMap<String,String>();
        map.put("result","success");
        map.put("info","成功了！");
        return new ResponseEntity(map, null, HttpStatus.OK);
    }
}
