package com.itheima.nacos.provider.controller;

import com.itheima.nacos.provider.Entity.Payment;
import com.itheima.nacos.provider.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 提供方要做的就是把自己的网络地址注册到服务发现中心
 */
@RestController
@Slf4j
public class RestProviderController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap=new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L,"123456732"));
        hashMap.put(1L,new Payment(1L,"6543263343"));
        hashMap.put(1L,new Payment(1L,"7654325457"));
    }
    //暴露RESTful接口
    @GetMapping(value = "/payment/nacos/{id}")
    public String service(@PathVariable("id") Integer id){
        System.out.println("provider invoke!!");
        return "provider nacos registry,serverPort:" + serverPort +"\t id: " + id;
    }

    @GetMapping(value = "echo/{string}")
    public String echo(@PathVariable String string){
        return "Hello NaCos discovery " + string;
    }

    @GetMapping(value = "/service")
    public String service(){
        return "provider invoke !! " + serverPort;
    }

    @GetMapping(value = "/paymentSQl/{id}")
    public CommonResult<Payment> paymentSQl(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        log.info("获取支付信息[{}]",payment);
        CommonResult<Payment> paymentCommonResult = new CommonResult<>(200, "from mysql,serverPort: " + serverPort, payment);
        log.info("获取支付结果[{}]",paymentCommonResult);
        return paymentCommonResult;
    }
}
