package com.katomegumi.zxojbackendjudgeservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
//要扫描整个包 不然有些bean加载不到
@ComponentScan("com.katomegumi")
@EnableDiscoveryClient
//这意味着Spring Boot会扫描这个包及其子包中的所有Feign客户端接口，并将它们注册为Spring Bean。
@EnableFeignClients(basePackages = {"com.katomegumi.zxojbackendserviceclient.service"})
public class ZxojBackendJudgeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZxojBackendJudgeServiceApplication.class, args);
    }

}
