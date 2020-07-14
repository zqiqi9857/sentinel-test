package com.itheima.nacos.config.ExceptionHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.itheima.nacos.config.Utils.CommonResult;

public class CustomerBlockHandler {
    public static CommonResult handerException(BlockException exception){
        return new CommonResult(444,"按客户自定义，global handleException-----1");
    }
    public static CommonResult handerException2(BlockException exception){
        return new CommonResult(444,"按客户自定义，global handleException-----2");
    }

}
