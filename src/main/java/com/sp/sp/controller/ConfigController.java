package com.sp.sp.controller;

import com.sp.sp.config.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 1.application.yml的配置值到对象的绑定过程，以及绑定到指定属性的方式
 * */
@RestController
public class ConfigController {
    @Autowired
    private LimitConfig limitConfig;

    //单独将配置文件里面的值配置到对象里面的属性里面来
    @Value("${limit.useParam})")
    private String useParam;

    @GetMapping("/hello")
    String say(){
        String fg = limitConfig.getSetParam();
        return fg + "dsdsd" + useParam;
    }
}
