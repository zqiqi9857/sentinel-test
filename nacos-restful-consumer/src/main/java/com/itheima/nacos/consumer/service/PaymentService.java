package com.itheima.nacos.consumer.service;

import com.itheima.nacos.consumer.Entity.Payment;
import com.itheima.nacos.consumer.utils.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * fegin就是接口加注解
 * 所谓的接口加注解就是后续我的controller就不在去找我的RestTemplate
 * 现在我们的习惯还是XXController调用XXService,
 * 现在订单要调Payment所有叫paymentService
 *
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSQl/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
