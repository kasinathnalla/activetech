package com.arkiv.sports.referee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arkiv.sports.referee.dao.LoginDAO;
import com.arkiv.sports.referee.model.MongoUser;

/**
 * Created by knalla on 1/21/17.
 */
@Service
public class UserService {
    @Autowired
    private LoginDAO loginDAO;

    public MongoUser save() {
        MongoUser user = new MongoUser();
        user.setId(""+Math.random());
        user.setFirstName("Kasi");
        user.setLastName("Nalla");
        user = loginDAO.save(user);
        return user;

    }
}
