package com.arkiv.sports.referee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.arkiv.sports.referee.dao.LoginDAO;
import com.arkiv.sports.referee.model.MongoUser;

public class MongoDbAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    @Autowired
    private LoginDAO loginDAO;

    @Override
    protected void additionalAuthenticationChecks( UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken )
            throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser( String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken ) throws AuthenticationException {

        MongoUser mongoUser = loginDAO.findByUserName( username );
        User user = new User( mongoUser.getUserName( ), mongoUser.getPassword( ), null );
        return user;
    }
}
