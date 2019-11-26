package com.fesine.payment.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fesine.payment.po.Balance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2019/11/26
 * @update:修改内容
 * @author: fesine
 * @updateTime:2019/11/26
 */
@RefreshScope
@RestController
public class PaymentController {
    @Value("${sleep:0}")
    private int sleep;

    final static Map<Integer, Balance> balanceMap = new HashMap() {
        {
            put(1, new Balance(1, 10, 1000));
            put(2, new Balance(2, 0, 10000));
            put(3, new Balance(3, 100, 0));
        }
    };

    /**
     * 使用sentinel进行限流熔断
     */
    @SentinelResource(value = "protected-resource", blockHandler = "handleBlock")
    @RequestMapping("/pay/balance/{id}")
    public Balance getBalance(@PathVariable Integer id) {
        System.out.println("request: /pay/balance?id=" + id + ", sleep: " + sleep);
        if (sleep > 0) {
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (id != null && balanceMap.containsKey(id)) {
            return balanceMap.get(id);
        }
        return new Balance(0, 0, 0);
    }

    public Balance handleBlock(Integer id, BlockException e) {
        System.out.println("请求太快，进行限流");
        return new Balance(0, 0, 0, "限流");
    }

}
