package com.welab.edda.service;

import com.welab.edda.proxy.T24Proxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestServiceImpl implements TestService{

    private T24Proxy t24Proxy;

    @Autowired
    public TestServiceImpl(T24Proxy t24Proxy) {
        this.t24Proxy = t24Proxy;
    }

    @Override
    public String getCustomer(String customerId){
        String t24CustomerId = t24Proxy.getT24Info(customerId);
        log.info("get t24 customer:{}", t24CustomerId);
        return t24CustomerId;
    }
}
