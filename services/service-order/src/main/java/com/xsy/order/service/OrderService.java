package com.xsy.order.service;

import com.xsy.order.bean.Order;

public interface OrderService {

    Order createOrder(Long productId, Long userId);

}
