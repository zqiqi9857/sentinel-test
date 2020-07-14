package com.itheima.nacos.config.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.itheima.nacos.config.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/testA")
    public String testA(){
        long start = System.nanoTime();
        log.info("当前线程名称[{}]",Thread.currentThread().getName());
        log.info("进入方法[{}]","testA");
        long time = System.nanoTime() - start;

        return "----testA "+ serverPort + "执行所用时长: " + time;
    }
    @GetMapping(value = "/testB")
    public String testB(){
        long start = System.nanoTime();
        log.info("当前形成名称[{}]",Thread.currentThread().getName());
        log.info("进入方法[{}]","testB");
        long time = System.nanoTime() - start;
        return "----testB " + serverPort + "执行所用时长: " + time;
    }
    @GetMapping(value = "/testD")
    public String testD(){
        long start = System.nanoTime();
        //暂停几分钟线程
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){e.printStackTrace();}
        log.info("进入测试方法[{}]","testD 测试RT");
        long time = System.nanoTime() - start;
        return "****testD 执行所用的时长: "+time ;
    }
    @GetMapping(value = "/testE")
    public String testE(){
        log.info("测试异常数");
        int age=10/0;
        return Thread.currentThread().getName()+ "\t *** testE";
    }
    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2)
    {
        long start = System.nanoTime();
        //int age=10/0;
        log.info(Thread.currentThread().getName()+ "\t ******* testHotKey");
        long time = System.nanoTime() - start;
      return "******* testHotKey 执行的时长: " +time;
    }
    public String deal_testHotKey(String p1, String p2, BlockException exception){
        long start = System.nanoTime();
        log.info(Thread.currentThread().getName() +"\t deal_testHotKey o(╥﹏╥)o");
        long time = System.nanoTime() - start;
     return "deal_testHotKey o(╥﹏╥)o 执行所用的时长: " +time;
    }

    @GetMapping(value = "/testAddPayment")
    public String testAddPayment(){
        Payment payment=new Payment();
        payment.setId(9L).setSerial("1024");
//        payment.setSerial("1020");
        return "testAddPayment success";
    }
}
