package com.itheima.nacos.config.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageMapper {
    //扣减库存
    public void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
