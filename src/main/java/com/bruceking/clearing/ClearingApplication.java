package com.bruceking.clearing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class, SecurityFilterAutoConfiguration.class})
@MapperScan("com.bruceking.clearing.mapper")
@EnableScheduling //开启对定时任务的支持
public class ClearingApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClearingApplication.class,args);
    }
}
