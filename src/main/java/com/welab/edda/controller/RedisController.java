package com.welab.edda.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RedisController {


    private RedisTemplate redisTemplate;

    @Autowired
    public RedisController(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostMapping(path = "/health/{key}/{value}")
    public String setKey(@PathVariable("key")String key, @PathVariable("value") String value){
        log.info("post key 测试");
        redisTemplate.opsForValue().set(key, value);
        Object valueString = redisTemplate.opsForValue().get(key);
        System.out.println("valueString:"+valueString);
        return valueString.toString();
    }

    @GetMapping(path = "/health/{key}")
    public String getKey(@PathVariable("key")String key){
        System.out.println("get key 测试");
        Object valueString = redisTemplate.opsForValue().get(key);
        System.out.println("valueString:"+valueString);
        return valueString.toString();
    }

}
