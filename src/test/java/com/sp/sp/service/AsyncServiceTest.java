package com.sp.sp.service;

import com.sp.sp.exception.SpException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AsyncServiceTest {

    @Autowired
    private AsyncService asyncService;

    @Test
    void say() throws InterruptedException {

        asyncService.say();
        asyncService.say2();

        Thread.sleep(1000*3);

    }

    @Test
    void say2() {
    }
}