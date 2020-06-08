package com.welab.edda.controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(MyController.class)
@ContextConfiguration(classes={MyController.class})
public class JunitController {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void test() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("accept", "application/json");
        headers.add("Content-Type", "application/json");
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/customers/{customer}", "900").contentType(
                        MediaType.APPLICATION_JSON
        ).headers(headers);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"1\":\"900\"}")).andReturn();
    }
}
