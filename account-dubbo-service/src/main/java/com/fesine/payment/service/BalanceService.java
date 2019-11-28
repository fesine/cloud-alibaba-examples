package com.fesine.payment.service;

import com.fesine.payment.po.Balance;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2019/11/28
 * @update:修改内容
 * @author: fesine
 * @updateTime:2019/11/28
 */
public interface BalanceService {
    Balance getBalance(Integer id);
}
