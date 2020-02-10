package com.sp.sp.repository;

import com.sp.sp.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel,Long> {


    /**
     * 条件查询订单
     */

    @Query(value="select username,name from UserModel")
    List<Map<Object,Object>> List();

}
