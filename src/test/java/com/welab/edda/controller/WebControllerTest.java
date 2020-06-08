package com.welab.edda.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CustomerController.class})
@WebMvcTest(CustomerController.class)
//@WebAppConfiguration
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {CustomerController.class})
public class WebControllerTest {

    @Autowired
    private MockMvc mockMvc;
//@Autowired
//private WebApplicationContext context;
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//    }

    @Test
    public void testWebMap() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/customer/{name}","testname"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"result\":\"success\"}")).andReturn();
    }
}
