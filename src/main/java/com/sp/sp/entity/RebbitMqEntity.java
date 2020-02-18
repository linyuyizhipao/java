package com.sp.sp.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class RebbitMqEntity implements Serializable {

    private String id;
    private String username;
    private String password;
    private String name;
    private int age;
}
