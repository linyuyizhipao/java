package com.sp.sp.controller;

import com.sp.sp.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/showRedis")
    Object say(){
        return redisUtil.get("sd");
    }

}
