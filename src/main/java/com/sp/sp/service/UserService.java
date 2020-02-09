package com.sp.sp.service;


import com.sp.sp.model.mongo.UserModel;
import com.sp.sp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

   //用户登录
    public boolean login(String userName,String passWord){
        if(userName.equals("")){
            return false;
        }
        if(passWord.equals("")){
            return false;
        }

        UserModel user = userRepository.findUserByUserName(userName);
        if (user.getPassWord().equals(passWord)){
            //登陆成功
            return true;
        }
        return false;
    }
    //用户注册
    public boolean register(UserModel userModel){
        userRepository.saveUser(userModel);
        return true;
    }
    //获取用户信息
    public UserModel getUserInfo(String userName){
        return userRepository.findUserByUserName(userName);
    }

    //修改用户信息
    public long editNickName(String userName,String nickName){
        return userRepository.editNickName(userName,nickName);
    }
}
