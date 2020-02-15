package com.sp.sp.controller;

import com.sp.sp.dto.CommonResult;
import com.sp.sp.entity.UserMongo;
import com.sp.sp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 1.控制器的路由绑定,参数绑定
 * 2.mongo的操作
 * */
@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping( "/login")
    @ResponseBody
    public Object login(@RequestParam(value = "user_name") String userName,
                        @RequestParam(value = "pass_word") String passWord
                        ) {
        boolean b = userService.login(userName,passWord);
        if(b == true){
            return "登陆成功";
        }
        return "登录失败";
    }


    @PostMapping( "/register")
    @ResponseBody
    public Object register(@RequestParam(value = "user_name",defaultValue = "hugo") String userName,
                        @RequestParam(value = "pass_word",defaultValue = "123") String passWord,
                        @RequestParam(value = "confirm_pass_word",defaultValue = "123") String confirm_pass_word,
                        @RequestParam(value = "nickName",defaultValue = "best") String nickName,
                        @RequestParam(value = "email",defaultValue = "13147199599@163.com") String emai,
                        @RequestParam(value = "headimgurl",defaultValue = "http://a4.att.hudong.com/21/09/01200000026352136359091694357.jpg") String headimgurl
    ) {
        if(!confirm_pass_word.equals(passWord)){
            return new CommonResult().failed();
        }

        UserMongo userMongo = new UserMongo();
        userMongo.setEmail(emai);
        userMongo.setHeadimgurl(headimgurl);
        userMongo.setNickName(nickName);
        userMongo.setUserName(userName);
        userMongo.setPassWord(passWord);
        boolean b = userService.register(userMongo);
        if(b == true){
            return new CommonResult().success(userMongo);
        }
        return new CommonResult().failed();
    }

    @GetMapping( "/getUserInfo")
    @ResponseBody
    public Object getUserInfo(@RequestParam(value = "user_name",defaultValue = "hugo") String userName
    ) {
        UserMongo userModel = userService.getUserInfo(userName);
        return userModel;
    }

    @GetMapping( "/editNickName")
    @ResponseBody
    public Object editNickName(@RequestParam(value = "user_name",defaultValue = "hugo") String userName,
                          @RequestParam(value = "nick_name",defaultValue = "nick_name") String nickName
    ) {
        long id = userService.editNickName(userName,nickName);
        return id;
    }
}
