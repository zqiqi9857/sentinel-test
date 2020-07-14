package com.itheima.nacos.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@Slf4j
public class RestConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    //通过负载均衡发现地址，流程是从服务发现中心拿到nacos-restful-provider服务列表，通过负载均衡算法获取一个服务地址
    @Autowired
    LoadBalancerClient loadBalancerClient;

    String serviceId="nacos-restful-provider";
    //要进行远程调用需要知识提供方IP和端口
    @Value("${service-url.nacos-user-service}")
    private String serverUrRL;

    /**
     * 方法一
     */
    @GetMapping(value = "/service")
    public String service(){
        //远程调用
        //RestTemplate restTemplate=new RestTemplate();
        String forObject = restTemplate.getForObject(serverUrRL + "/service", String.class);
        return "consumer invoke | " + forObject;
    }

    /**
     * 方法二
     */
    @GetMapping(value = "/service1")
    public String service1(){
        //远程调用
        // restTemplate=new RestTemplate();
        //发现一个地址
        ServiceInstance serviceInstance = loadBalancerClient.choose(serviceId);
        URI uri = serviceInstance.getUri();
        String forObject = restTemplate.getForObject(uri+"/service", String.class);
        return "consumer invoke LoadBalancerClient | " + forObject;
    }

    /**
     * 方法三
     */
   @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id){
      return restTemplate.getForObject(serverUrRL+"/payment/nacos/"+id,String.class);
   }

}
