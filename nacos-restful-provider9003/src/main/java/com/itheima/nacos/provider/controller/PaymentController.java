package com.itheima.nacos.provider.controller;

import com.itheima.nacos.provider.Entity.Payment;
import com.itheima.nacos.provider.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String ServerPort;

    public static HashMap<Long, Payment> hashMap=new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L,"123456732"));
        hashMap.put(1L,new Payment(1L,"6543263343"));
        hashMap.put(1L,new Payment(1L,"7654325457"));
    }
    @GetMapping(value = "/paymentSQl/{id}")
    public CommonResult<Payment> paymentSQl(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        log.info("获取支付信息[{}]",payment);
        CommonResult<Payment> paymentCommonResult = new CommonResult<>(200, "from mysql,serverPort: " + ServerPort, payment);
        log.info("获取支付结果[{}]",paymentCommonResult);
        return paymentCommonResult;
    }
}
