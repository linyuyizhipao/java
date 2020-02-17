package com.sp.sp.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncService {

    @Async
    void say(){
        for (int i = 0;i<1000;i++){
            System.out.println("我是1" + i);
        }
    }

    @Async
    void say2(){
        for (int i = 0;i<1000;i++){
            System.out.println("天下1" + i);
        }
    }

}
