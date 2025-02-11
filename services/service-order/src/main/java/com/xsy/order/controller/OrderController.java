package com.xsy.order.controller;

import com.xsy.order.bean.Order;
import com.xsy.order.config.OrderProperties;
import com.xsy.order.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope // 刷新配置
@RestController
public class OrderController {

    @Resource
    OrderService orderService;

    // 使用@ConfigurationProperties代替
    @Resource
    OrderProperties orderProperties;
    // @Value("${order.timeout}")
    // private String orderTimeout;
    //
    // @Value("${order.auto-confirm}")
    // private String orderAutoConfirm;

    @GetMapping("/config")
    public String getConfig() {
        return orderProperties.getTimeout() + " " + orderProperties.getAutoConfirm();
    }


    @GetMapping("/createOrder")
    public Order createOrder(@RequestParam("productId") Long productId,
                             @RequestParam("userId") Long userId) {
        return orderService.createOrder(productId, userId);
    }


}
