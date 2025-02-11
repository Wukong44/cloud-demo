package com.xsy.order.feign;

import com.xsy.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-product")
public interface ProductFeign {

    @GetMapping("/product/{id}")
    Product getProductInfo(@PathVariable("id") Long productId);

}

