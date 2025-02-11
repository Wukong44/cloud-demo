package com.xsy.order.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "order")
public class OrderProperties {

    private String timeout;

    private String autoConfirm;

}

