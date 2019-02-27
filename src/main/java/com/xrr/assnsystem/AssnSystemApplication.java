package com.xrr.assnsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xrr.assnsystem.mapper")
public class AssnSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssnSystemApplication.class, args);
    }

}
