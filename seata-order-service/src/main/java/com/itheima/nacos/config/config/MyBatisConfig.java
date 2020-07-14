package com.itheima.nacos.config.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @auther zzyy
 * @create 2019-12-11 16:57
 */
@Configuration
@MapperScan({"com.itheima.nacos.config.dao"})
public class MyBatisConfig {
}
