package com.sp.sp.controller;

import com.sp.sp.entity.UserModel;
import com.sp.sp.repository.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

/**
* 1.原生sql执行
* 2.repository 的一些原生方法执行
 * 3. 数据库开启事务
* */

@RestController
public class MysqlController {
    @Autowired
    private UserModelRepository userModelRepository;

    @GetMapping("/show")
    Object say(){
        List fg = userModelRepository.findAll();

        UserModel rr =  userModelRepository.findById(1).orElse(null);
        //sql直接执行
        List sql =  userModelRepository.List();

        return sql;
    }

    /**
    * 事务其作用了  age在数据库里面是tinyint
    *
    * */
    @Transactional
    @GetMapping("/tr")
    public void saveUser(){
        UserModel u = new UserModel();
        u.setId(2);
        u.setName("qq");
        u.setAge(33);
        userModelRepository.save(u);

        UserModel u2 = new UserModel();
        u2.setId(1);
        u2.setName("ww");
        u2.setAge(33333);

        userModelRepository.save(u2);
    }

}
