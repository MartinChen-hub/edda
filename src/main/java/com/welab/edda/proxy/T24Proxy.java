package com.welab.edda.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class T24Proxy {
    public String getT24Info(String customerId){
log.info("you are in t24proxy now");
        return "T24"+ customerId;
    }
}
