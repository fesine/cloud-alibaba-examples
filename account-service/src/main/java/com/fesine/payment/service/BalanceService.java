package com.fesine.payment.service;

import com.fesine.payment.po.Balance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2019/11/26
 * @update:修改内容
 * @author: fesine
 * @updateTime:2019/11/26
 */
@FeignClient(name = "payment-service", fallback = BalanceServiceFallback.class)
public interface BalanceService {
    @GetMapping(value = "/pay/balance/{id}")
    Balance getBalance(@PathVariable("id") Integer id);
}
