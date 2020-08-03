package com.edda.controller;

import com.edda.proxy.BankProxy;
import com.edda.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
//@Api(tags = "test 用户管理")
public class Controller {

    private TestService testService;

    private BankProxy bankProxy;

    @Autowired
    public Controller(TestService testService, BankProxy bankProxy){
        this.testService = testService;
        this.bankProxy = bankProxy;
    }

    @ApiOperation("查询用户")
    @GetMapping(path="/test/customers/{customerId}")
    public String getCustomer(@PathVariable String customerId){
        log.info("webhook test 5: get a controller request:{}", customerId);
        String t24CustomerId = testService.getCustomer(customerId);
        return "webhook test 6 "+t24CustomerId;
    }

    @ApiOperation("添加用户")
    @PostMapping(path="/test/customers/{customerId}")
    public String createCustomer(@PathVariable String customerId){
        log.info("create a controller request:{}", customerId);
        String t24CustomerId = testService.getCustomer(customerId);
        return t24CustomerId;
    }

    @GetMapping(path = "/test/banks/{bankCode}")
    public String getBankName(@PathVariable String bankCode){
        log.info("controller receive a request");
        log.info("Receive a request to get bank name from bank code({})", bankCode);
        String bankName = "We cannot find bank "+bankCode;
        Map<String, String> banks = bankProxy.getBank();
        if(banks!=null){
            String bankNameTemp = banks.get(bankCode);
            if(StringUtils.isNotBlank(bankNameTemp)){
                bankName = bankNameTemp;
            }
        }
        return bankName;
    }
}
