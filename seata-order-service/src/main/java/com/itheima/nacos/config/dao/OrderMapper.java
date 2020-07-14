package com.itheima.nacos.config.dao;

import com.itheima.nacos.config.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {
    //1.新建订单
    public void create(Order order);
    //2 修改订单状态从零给为1
    public void update(@Param("userId") Long userId,@Param("status") Integer status);
}
