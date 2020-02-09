package com.sp.sp.repository;

import com.sp.sp.model.mysql.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MysqlRepository extends JpaRepository <UserModel,Long> {
    /**
     * 条件查询订单
     */

    @Query("select username from tbl_user")
    List<UserModel> List();

}
