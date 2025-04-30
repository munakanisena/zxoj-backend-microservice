package com.katomegumi.zxojbackenduserservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.katomegumi.zxojbackenduserservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
//要扫描整个包 不然有些bean加载不到
@ComponentScan("com.katomegumi")
public class ZxojBackendUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZxojBackendUserServiceApplication.class, args);
    }

}
