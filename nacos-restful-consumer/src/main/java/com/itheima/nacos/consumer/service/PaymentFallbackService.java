package com.itheima.nacos.consumer.service;

import com.itheima.nacos.consumer.Entity.Payment;
import com.itheima.nacos.consumer.utils.CommonResult;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降价返回-----PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
