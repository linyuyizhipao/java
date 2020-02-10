package com.sp.sp;

import com.sp.sp.repository.UserModelRepository;
import com.sp.sp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserModelRepository userModelRepository;

    @Test
    public void contextLoads() {
        System.out.println("我来测试一下");
    }
    @Test
    void contextLoads2() {
        List<Map<Object,Object>> user = userModelRepository.List();
        for(Map<Object,Object> u :user){

            for(Map.Entry<Object, Object> vo : u.entrySet()){
                vo.getKey();
                vo.getValue();
                System.out.println(vo.getKey()+"  "+vo.getValue());
            }

        }
    }
}
