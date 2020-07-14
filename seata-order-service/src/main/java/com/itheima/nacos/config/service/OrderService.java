package com.itheima.nacos.config.service;

import com.itheima.nacos.config.domain.Order;

public interface OrderService {
    //1.新建订单
    public void create(Order order);
}
