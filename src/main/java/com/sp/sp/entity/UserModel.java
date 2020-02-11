package com.sp.sp.entity;



import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity 这个注解得设置，因为java的jpa使用到了
 * Data 这是一个自动帮我们生成setProprty的
 *
 */
@Entity
@Data
@Table(name = "tbl_user")
public class UserModel implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String name;
    private int age;
}
