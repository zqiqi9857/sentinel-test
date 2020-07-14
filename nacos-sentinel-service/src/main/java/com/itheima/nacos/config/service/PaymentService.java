package com.itheima.nacos.config.service;
import com.itheima.nacos.config.entity.Payment;
import feign.Param;

public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
    public Payment selectByPrimaryKey(@Param("id") Long id);
}
