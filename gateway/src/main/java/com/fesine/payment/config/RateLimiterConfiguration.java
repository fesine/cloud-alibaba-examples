package com.fesine.payment.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2019/11/27
 * @update:修改内容
 * @author: fesine
 * @updateTime:2019/11/27
 */
@Configuration
public class RateLimiterConfiguration {
    @Bean(value = "ipKeyResolver")
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }

}
