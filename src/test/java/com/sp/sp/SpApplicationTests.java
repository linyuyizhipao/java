package com.sp.sp;

import com.sp.sp.componen.ImlOne;
import com.sp.sp.entity.RebbitMqEntity;
import com.sp.sp.entity.UserModel;
import com.sp.sp.repository.UserModelRepository;
import com.sp.sp.repository.UserRepository;
import com.sp.sp.service.MessageSenderService;
import com.sp.sp.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;

@SpringBootTest
class SpApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private MessageSenderService messageSenderService;

    @Autowired
    private RedisUtil redisUtil;


    @Autowired
    @ImlOne("")
    private UserModelRepository userModelRepository;


    @Test
    public void contextLoads() {

        Map<String,String> m =new HashMap<String, String>();
        m.put("ds","fddf");

        List<Map<String,String>> person=new ArrayList<Map<String,String>>();
        person.add(0,m);


        System.out.println(person);
    }
    @Test
    void contextLoads2() {
        List<UserModel> user = userModelRepository.List();

        for (int i = 0; i < user.size(); i++) {

            System.out.println(user.get(i));
        }

    }

    @Test
    public void testRedis() throws Exception {
        redisUtil.set("sd","qqq");
        Object fd = redisUtil.get("sd");
        System.out.println(fd);
    }
    @Test
    public void testExpire() throws Exception {
        long fd = redisUtil.getExpire("sd");
        System.out.println(fd);
    }
    @Test
    public void sendR() {
        RebbitMqEntity rebbitMqEntity = new RebbitMqEntity();
        rebbitMqEntity.setAge(3);
        rebbitMqEntity.setName("hugohugo");
        messageSenderService.send(rebbitMqEntity);
    }
}
