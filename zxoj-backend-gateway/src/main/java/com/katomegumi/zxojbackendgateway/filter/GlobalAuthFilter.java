package com.katomegumi.zxojbackendgateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @author : 惠
 * @description : 全局过滤器 防止内部服务(调用) 被访问
 * @createDate : 2025/5/1 下午11:22
 */
public class GlobalAuthFilter  implements GlobalFilter, Ordered {

    private final AntPathMatcher antPathMatcher=new AntPathMatcher();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
        if(antPathMatcher.match("/**/inner/**",path)){
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.FORBIDDEN);
            DataBufferFactory dataBufferFactory = response.bufferFactory();
            return response.writeWith(Mono.just(dataBufferFactory.wrap("禁止访问".getBytes(StandardCharsets.UTF_8))));
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        //提高优先级
        return 0;
    }
}

