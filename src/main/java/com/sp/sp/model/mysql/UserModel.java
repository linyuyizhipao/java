package com.sp.sp.model.mysql;



import javax.persistence.*;

/**
 * Created by Annan.Wang on 2019/4/18.
 * Description:
 * Coding Changes World :)
 */
@Entity
@Table(name = "tbl_user")
public class UserModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    //get set省略
}
