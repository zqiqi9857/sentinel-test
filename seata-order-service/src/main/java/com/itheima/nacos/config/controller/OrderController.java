package com.itheima.nacos.config.controller;

import com.itheima.nacos.config.domain.Order;
import com.itheima.nacos.config.service.OrderService;
import com.itheima.nacos.config.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order/create")
    public Result create(Order order){
        orderService.create(order);
        return new Result(200,"订单创建成功！！！");
    }

}
