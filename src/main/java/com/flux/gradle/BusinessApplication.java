package com.flux.gradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Description 启动入口文件$
 **/
@SpringBootApplication
@EnableCaching
public class BusinessApplication {
    public static void main(String[] args){
        SpringApplication.run(BusinessApplication.class, args);
    }
}
