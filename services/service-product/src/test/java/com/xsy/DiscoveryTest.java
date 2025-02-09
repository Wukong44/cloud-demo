package com.xsy;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@SpringBootTest
public class DiscoveryTest {
    
    @Resource
    DiscoveryClient discoveryClient;

    @Test
    void test() {
        for (String service : discoveryClient.getServices()) {
            System.out.println(service);
            discoveryClient.getInstances(service).forEach(instance -> {
                System.out.println("ip" + instance.getHost()  + instance.getServiceId() + " " + instance.getUri());
            });
        }
    }
}
