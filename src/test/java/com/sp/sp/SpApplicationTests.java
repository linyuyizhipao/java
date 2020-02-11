package com.sp.sp;

import com.sp.sp.entity.UserModel;
import com.sp.sp.repository.UserModelRepository;
import com.sp.sp.repository.UserRepository;
import org.json.JSONObject;
import org.json.JSONString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class SpApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
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
}
