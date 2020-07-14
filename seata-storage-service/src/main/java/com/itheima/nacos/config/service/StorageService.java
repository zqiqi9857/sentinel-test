package com.itheima.nacos.config.service;

public interface StorageService {
    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    public void decrease(Long productId, Integer count);
}
