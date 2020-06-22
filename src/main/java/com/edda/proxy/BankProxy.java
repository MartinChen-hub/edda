package com.edda.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(value = "${bank.name}", url = "${bank.url}")
public interface BankProxy {

    @GetMapping(path = "/bank/all")
    public Map<String, String> getBank();
}
