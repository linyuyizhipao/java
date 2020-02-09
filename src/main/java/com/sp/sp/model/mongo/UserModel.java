package com.sp.sp.model.mongo;

import java.io.Serializable;

public class UserModel implements Serializable {
    private static final long serialVersionUID = -3258839839160856613L;
    private int id;
    private String userName;
    private String passWord;
    private String email;
    private String nickName;
    private String createTime;
    private String headimgurl;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }
}
