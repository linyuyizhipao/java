package com.sp.sp.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class UserMongo implements Serializable {
    private String userName;
    private String passWord;
    private String email;
    private String nickName;
    private String createTime;
    private String headimgurl;
}
