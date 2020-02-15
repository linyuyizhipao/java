package com.sp.sp.service;


import com.sp.sp.entity.UserMongo;
import com.sp.sp.enums.ResultEnum;
import com.sp.sp.exception.SpException;
import com.sp.sp.repository.UserRepository;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    StringEncryptor stringEncryptor;

    //用户登录
    public boolean login(String userName,String passWord){
        if(userName.equals("")){
            return false;
        }
        if(passWord.equals("")){
            return false;
        }

        UserMongo user = userRepository.findUserByUserName(userName);
        if (user.getPassWord().equals(passWord)){
            //登陆成功
            return true;
        }
        return false;
    }
    //用户注册
    public boolean register(UserMongo userModel) throws SpException {

        UserMongo uInfo = userRepository.findUserByUserName(userModel.getUserName());
        if(uInfo != null){
            throw new SpException(ResultEnum.AUTH_USERNAME_EXSIT);
        }

        String encryptPassWord = stringEncryptor.encrypt(userModel.getPassWord());
        userModel.setPassWord(encryptPassWord);
        userRepository.saveUser(userModel);
        return true;
    }
    //获取用户信息
    public UserMongo getUserInfo(String userName){
        return userRepository.findUserByUserName(userName);
    }

    //修改用户信息
    public long editNickName(String userName,String nickName){
        return userRepository.editNickName(userName,nickName);
    }
}
