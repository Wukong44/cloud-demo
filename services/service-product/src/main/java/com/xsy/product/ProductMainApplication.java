package com.xsy.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient// 通过 Spring Cloud 原生注解 @EnableDiscoveryClient 开启服务注册发现功能
@EnableFeignClients
@SpringBootApplication
public class ProductMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductMainApplication.class, args);
        System.out.println("ProductMainApplication  up success!");
    }
}