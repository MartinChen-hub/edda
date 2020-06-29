package com.edda.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "${customer.name}", url = "${customer.url}")
public interface CustomerProxy {

    @GetMapping(path = "/cu-test/customers/{customerId}")
    public String getCustomerName(@PathVariable("customerId") String customerId);
}
