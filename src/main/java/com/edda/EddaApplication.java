package com.edda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * will add api swagger later
 */
@SpringBootApplication
@EnableFeignClients
public class EddaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EddaApplication.class, args);
    }

}
