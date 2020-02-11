package com.sp.sp.repository;

import com.sp.sp.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel,Integer> {


    /**
     * 这是执行sql语句，注意 nativeQuery=true要设置
     */

    @Query(value="select id,username,name,password from UserModel",nativeQuery = true)
    List<UserModel> List();

    //@Query(value="select username,name from UserModel")
    //List<Map> List();
}
