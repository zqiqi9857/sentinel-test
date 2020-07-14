package com.itheima.nacos.config.controller;

import com.itheima.nacos.config.dao.AccountMapper;
import com.itheima.nacos.config.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@Slf4j
public class AccountController {
    @Autowired
    private AccountMapper accountMapper;

    /**
     * 扣减账户余额
     * @param userId
     * @param money
     * @return
     */
    @GetMapping(value = "/account/decrease")
    public Result decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money){
       accountMapper.decrease(userId,money);
       return new Result(200,"扣减账户余额成功！！");
    }
}
