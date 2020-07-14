package com.itheima.nacos.config.service;

import com.itheima.nacos.config.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "seata-account-service")
public interface AccountService {
    /**
     * 账户扣款 需要提供账户userId 和当前余额
     * @param userId
     * @param money
     * @return
     */
    @PostMapping(value = "/account/decrease")
    Result decrease(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money);
}
