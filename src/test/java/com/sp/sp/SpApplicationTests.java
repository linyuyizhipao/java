package com.sp.sp;

import com.sp.sp.model.mongo.UserModel;
import com.sp.sp.repository.MysqlRepository;
import com.sp.sp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpApplicationTests {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void contextLoads() {
        System.out.println("我来测试一下");
    }
    @Test
    void contextLoads2() {
        System.out.println("师德师风");
    }
}
