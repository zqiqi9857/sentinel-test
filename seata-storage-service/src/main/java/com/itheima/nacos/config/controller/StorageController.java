package com.itheima.nacos.config.controller;

import com.itheima.nacos.config.service.StorageService;
import com.itheima.nacos.config.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StorageController {
    @Autowired
    private StorageService storageService;

    /**
     * 扣减库存
     * @param productId
     * @param count
     * @return
     */
    @GetMapping(value = "/storage/decrease")
    public Result decrease(Long productId,Integer count){
         storageService.decrease(productId,count);
         return new Result(200,"扣减库存成功");
    }
}
