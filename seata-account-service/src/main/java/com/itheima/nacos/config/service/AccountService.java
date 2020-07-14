package com.itheima.nacos.config.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

public interface AccountService {
    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money  金额
     */
    public void decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money);
}
