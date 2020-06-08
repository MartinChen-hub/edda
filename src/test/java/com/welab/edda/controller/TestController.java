package com.welab.edda.controller;

import com.welab.edda.EddaApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {EddaApplication.class},webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestController {

    @Autowired
    private TestRestTemplate testRestTemplate;

//    @Test
//    public void getUserByIdTest() throws Exception {
//        ResponseEntity<String> response = this.testRestTemplate.getForEntity(
//                "/test/customers/{customerId}", String.class, "10000007");
//        log.info("get测试结果为：{}", response.getBody().toString());
//        assertEquals("T2410000007",response.getBody());
//    }

//    @Test
//    public void createUserTest() throws Exception {
//        ResponseEntity<String> response = this.testRestTemplate.postForEntity(
//                "/test/customers/{customerId}", null, String.class,"10000007");
//        log.info("create测试结果为：{}", response.getBody().toString());
//        assertEquals("T2410000007",response.getBody());
//    }

//    @Test
//    public void testApi(){
//        Map map = new HashMap();
//        map.put("name","DUANMURONG");
//        ResponseEntity<String> response = testRestTemplate.postForEntity("/v1/customer/{name}",null,String.class,"1000");
//        String str = response.getBody();
//        System.out.println(str);
//    }

    @Test
    public void testApi(){
        ResponseEntity<String> response = this.testRestTemplate.postForEntity("/v1/customer/{name}",null,String.class,"duanmurong");
        String str = response.getBody();
        System.out.println(str);
    }
}
