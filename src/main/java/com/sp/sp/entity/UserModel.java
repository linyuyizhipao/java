package com.sp.sp.entity;



import lombok.Data;

import javax.persistence.*;

/**
 * Created by Annan.Wang on 2019/4/18.
 * Description:
 * Coding Changes World :)
 */
@Entity
@Data
@Table(name = "tbl_user")
public class UserModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String name;
}
