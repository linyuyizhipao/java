package com.sp.sp.repository;

import com.mongodb.client.result.UpdateResult;
import com.sp.sp.entity.UserMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class UserRepository  {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void saveUser(UserMongo user) {
        mongoTemplate.save(user);
    }

    //根据用户名查询用户信息
    public UserMongo findUserByUserName(String userName) {
        Query query= new Query(Criteria.where("userName").is(userName));
        UserMongo userModel =  mongoTemplate.findOne(query , UserMongo.class);
        return userModel;
    }
    //修改nickname
    public long editNickName(String userName,String nickName) {
        Query query= new Query(Criteria.where("userName").is(userName));
        Update update= new Update().set("nick_name",nickName);
        UpdateResult result = mongoTemplate.updateFirst(query,update,UserMongo.class);
        if(result!=null)
            return result.getMatchedCount();
        else
            return 0;
    }
}