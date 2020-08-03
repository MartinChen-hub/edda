package com.edda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * will add api swagger later
 */
@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
public class EddaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EddaApplication.class, args);
    }

}
