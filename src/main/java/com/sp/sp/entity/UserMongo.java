package com.sp.sp.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class UserMongo implements Serializable {
    private static final long serialVersionUID = -3258839839160856613L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String userName;
    private String passWord;
    private String email;
    private String nickName;
    private String createTime;
    private String headimgurl;
}
