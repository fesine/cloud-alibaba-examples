package com.fesine.payment.service;

import com.fesine.payment.po.Balance;
import org.springframework.stereotype.Component;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2019/11/26
 * @update:修改内容
 * @author: fesine
 * @updateTime:2019/11/26
 */
@Component
public class BalanceServiceFallback implements BalanceService {
    @Override
    public Balance getBalance(Integer id) {
        return new Balance(0, 0, 0, "降级");
    }
}
