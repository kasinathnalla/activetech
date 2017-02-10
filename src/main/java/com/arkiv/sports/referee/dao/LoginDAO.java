package com.arkiv.sports.referee.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.arkiv.sports.referee.model.MongoUser;

/**
 * Created by knalla on 1/21/17.
 */
@Component
public interface LoginDAO extends MongoRepository<MongoUser,String> {
    MongoUser findByUserName(String userName);
}
