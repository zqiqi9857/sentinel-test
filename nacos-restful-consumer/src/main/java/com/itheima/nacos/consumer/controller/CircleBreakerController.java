package com.itheima.nacos.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.itheima.nacos.consumer.Entity.Payment;
import com.itheima.nacos.consumer.service.PaymentService;
import com.itheima.nacos.consumer.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CircleBreakerController {
    public static final String SERVICE_URL="http://nacos-payment-provider";
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping(value = "/consumer/fallback/{id}")
    @SentinelResource(value = "fallback") //fallback负责业务异常
    public CommonResult<Payment> fallback(@PathVariable Long id){
        CommonResult result = restTemplate.getForObject(SERVICE_URL + "/paymentSQl/" + id, CommonResult.class, id);
        if (id==4){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
        }else if (result.getData()==null){
            throw new NullPointerException("NullPointerException,该id没有对应的记录,空指针异常");
        }
        return result;
    }

    @GetMapping(value = "/consumer/fallback2/{id}")
    @SentinelResource(value = "fallback2",blockHandler = "handlerFallback") //blockHandler负责sentinel控制台配置违规
    public CommonResult<Payment> fallback2(@PathVariable Long id){
        CommonResult result = restTemplate.getForObject(SERVICE_URL + "/paymentSQl/" + id, CommonResult.class, id);
        if (id==4){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
        }else if (result.getData()==null){
            throw new NullPointerException("NullPointerException,该id没有对应的记录,空指针异常");
        }
        return result;
    }

    @GetMapping(value = "/consumer/fallback3/{id}")
    @SentinelResource(value = "fallback3",fallback = "handlerFallback",blockHandler = "blockHandler") //blockHandler负责sentinel控制台配置违规
    public CommonResult<Payment> fallback3(@PathVariable Long id){
        CommonResult result = restTemplate.getForObject(SERVICE_URL + "/paymentSQl/" + id, CommonResult.class, id);
        if (id==4){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
        }else if (result.getData()==null){
            throw new NullPointerException("NullPointerException,该id没有对应的记录,空指针异常");
        }
        return result;
    }

    /**
     * 假如报异常，不再有fallback方法兜底，没有降价效果
     * @param id
     * @return
     */
    @GetMapping(value = "/consumer/fallback4/{id}")
    @SentinelResource(value = "fallback4",fallback = "handlerFallback",blockHandler = "blockHandler",exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback4(@PathVariable Long id){
        CommonResult result = restTemplate.getForObject(SERVICE_URL + "/paymentSQl/" + id, CommonResult.class, id);
        if (id==4){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
        }else if (result.getData()==null){
            throw new NullPointerException("NullPointerException,该id没有对应的记录,空指针异常");
        }
        return result;
    }
    //本例为Fallback兜底方法
    public CommonResult<Payment> handlerFallback(@PathVariable Long id,Throwable e){
        Payment payment = new Payment(id, "null");
        return new CommonResult<Payment>(444,"兜底异常handlerFallback,Exception内容"+e.getMessage(),payment);
    }

    //本例为blockHandler
    public CommonResult<Payment> blockHandler(@PathVariable Long id, BlockException blockException){
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(445,"blockHandler-sentinel限流,无此流水:blockException: " +blockException,payment);
    }
    //===============OpenFeign
    @Autowired
    private PaymentService paymentService;
    @GetMapping(value = "/consumer/paymentSQl/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }
}
