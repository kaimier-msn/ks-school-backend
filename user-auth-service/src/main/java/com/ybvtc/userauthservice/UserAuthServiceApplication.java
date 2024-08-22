package com.ybvtc.userauthservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ybvtc.userauthservice.mapper")
public class UserAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAuthServiceApplication.class, args);
    }

}
