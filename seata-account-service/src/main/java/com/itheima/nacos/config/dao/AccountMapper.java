package com.itheima.nacos.config.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountMapper {
    /**
     * 扣减账户余额 需要提供账户 和 余额
     * @param userId
     * @param money
     */
    public void decrease(@Param("userId") Long userId, @Param("money")BigDecimal money);
}
