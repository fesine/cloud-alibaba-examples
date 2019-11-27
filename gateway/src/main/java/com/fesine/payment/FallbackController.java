package com.fesine.payment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2019/11/27
 * @update:修改内容
 * @author: fesine
 * @updateTime:2019/11/27
 */
@RestController
public class FallbackController {
    @RequestMapping("/defaultFallback")
    public Map defaultFallback() {
        Map map = new HashMap<>();
        map.put("code", 1);
        map.put("message", "服务异常");
        return map;
    }
}
