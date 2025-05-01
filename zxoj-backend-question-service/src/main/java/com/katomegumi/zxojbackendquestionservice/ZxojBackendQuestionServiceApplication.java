package com.katomegumi.zxojbackendquestionservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.katomegumi.zxojbackendquestionservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
//要扫描整个包 不然有些bean加载不到
@ComponentScan("com.katomegumi")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.katomegumi.zxojbackendserviceclient.service"})
public class ZxojBackendQuestionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZxojBackendQuestionServiceApplication.class, args);
    }

}
