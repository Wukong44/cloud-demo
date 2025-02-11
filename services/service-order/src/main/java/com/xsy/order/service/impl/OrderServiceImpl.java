package com.xsy.order.service.impl;
import java.math.BigDecimal;
import java.util.Arrays;

import com.xsy.order.bean.Order;
import com.xsy.order.feign.ProductFeign;
import com.xsy.order.service.OrderService;
import com.xsy.product.bean.Product;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    ProductFeign productFeign;

    @Resource //一定导入 spring-cloud-starter-loadbalancer
    LoadBalancerClient loadBalancerClient;

    @Override
    public Order createOrder(Long productId, Long userId) {
        Order order = new Order();
        order.setId(1L);

        Product productInfo = productFeign.getProductInfo(productId);

        // 注意这里feign调用的是Ribbon的负载均衡算法，和loadBalancerClient.choose的算法不同，所以不能命中同一个服务
        // 即使强制feign使用loadBalancerClient算法负载也不能命中同一个，因为每次choose的结果都不一样，feign调用和loadBalancerClient.choose是独立的两次调用
        // ServiceInstance choose = loadBalancerClient.choose("service-product");
        //远程URL
        // String url = "http://"+choose.getHost() +":" +choose.getPort() +"/product/"+productId;
        // log.info("远程请求：{}",url);

        order.setTotalAmount(productInfo.getPrice().multiply(new BigDecimal(productInfo.getNum())) );
        order.setUserId(userId);
        order.setNickName("sisi");
        order.setAddress("ChongQing");
        order.setProductList(Arrays.asList(productInfo, productInfo));

        return order;
    }
}
