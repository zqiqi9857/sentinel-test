package com.itheima.nacos.config.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.itheima.nacos.config.ExceptionHandler.CustomerBlockHandler;
import com.itheima.nacos.config.Utils.CommonResult;
import com.itheima.nacos.config.entity.Payment;
import com.itheima.nacos.config.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RateLimitController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/byResource/{id}")
    @SentinelResource(value = "byResource",blockHandler = "handException")
    public CommonResult byResource(@PathVariable("id") Long id){
        Payment paymentById = paymentService.selectByPrimaryKey(id);
        log.info("获取支付信息[{}]",paymentById);
        return new CommonResult(200,"按资源名称限流ok",paymentById);
    }
    public CommonResult handException(BlockException exception){
     return new CommonResult(444,exception.getClass().getCanonicalName()+ "\t 服务器不可用");
    }

    @GetMapping(value = "/rateLimit/byUrI/{id}")
    @SentinelResource(value = "byUrI")
    public CommonResult byUrI(@PathVariable("id") Long id){
        Payment byId = paymentService.getPaymentById(id);
        log.info("获取的支付信息[{}]",byId);
        return new  CommonResult(200,"按url限流测试OK",byId);
    }

    @GetMapping(value = "/rateLimit/customerBlockHandler/{id}")
    @SentinelResource(value = "customerBlockHandler",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handerException2")
    public CommonResult  customerBlockHandler(@PathVariable("id") long id){
        Payment byPrimaryKey = paymentService.selectByPrimaryKey(id);
        return new CommonResult(200,"按客户自定义",byPrimaryKey);

    }
}
