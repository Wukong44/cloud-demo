package com.xsy.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient// 通过 Spring Cloud 原生注解 @EnableDiscoveryClient 开启服务注册发现功能
@EnableFeignClients
@SpringBootApplication
public class OrderMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainApplication.class, args);
        System.out.println("OrderMainApplication  up success!");
    }
}