package com.fesine.payment.controller;

import com.fesine.payment.po.Balance;
import com.fesine.payment.po.User;
import com.fesine.payment.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RestController
public class AccountController {
    @Autowired
    private BalanceService balanceService;
    final static Map<Integer, User> userMap = new HashMap() {
        {
            put(1, new User(1, "张三"));
            put(2, new User(2, "李四"));
            put(3, new User(3, "王五"));
        }
    };

    @GetMapping("/acc/user/{id}")
    public User getUser(@PathVariable Integer id) {
        if (id != null && userMap.containsKey(id)) {
            User user = userMap.get(id);
            Balance balance = balanceService.getBalance(id);
            user.setBalance(balance);
            return user;
        }
        return new User(0, "");
    }

}
