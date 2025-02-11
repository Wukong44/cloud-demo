package com.xsy.product.controller;

import com.xsy.product.bean.Product;
import com.xsy.product.service.ProductService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Resource
    ProductService productService;

    @GetMapping("/product/{id}")
    Product getProductInfo(@PathVariable("id") Long productId,
                           HttpServletRequest request) {
        System.out.println("请求头：" + request.getHeader("x-token"));
        return productService.getProductInfo(productId);
    }
}
