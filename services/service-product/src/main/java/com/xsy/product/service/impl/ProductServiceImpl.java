package com.xsy.product.service.impl;

import java.math.BigDecimal;
import java.net.http.HttpRequest;
import java.util.concurrent.TimeUnit;

import com.xsy.product.bean.Product;
import com.xsy.product.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProductInfo(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setPrice(new BigDecimal("99"));
        product.setProductName("苹果-" + product.getId());
        product.setNum(2);
        System.out.println("hello");


        // try {
        //     // 休眠6s测试feign处理超时
        //     TimeUnit.SECONDS.sleep(6);
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }
        return product;
    }
}
