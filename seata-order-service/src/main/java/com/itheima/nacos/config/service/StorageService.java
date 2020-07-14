package com.itheima.nacos.config.service;

import com.itheima.nacos.config.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service")
public interface StorageService {
    /**
     * 更新库存数量 需要提供产品id和数量
     * @param productId
     * @param count
     * @return
     */
    @PostMapping(value = "/storage/decrease")
    Result decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
