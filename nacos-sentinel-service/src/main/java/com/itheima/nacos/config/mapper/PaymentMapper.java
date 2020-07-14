package com.itheima.nacos.config.mapper;

import com.itheima.nacos.config.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
    public Payment selectByPrimaryKey(@Param("id") Long id);
}
