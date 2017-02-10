package com.arkiv.sports.referee.model;

/**
 * Created by knalla on 1/21/17.
 */

import java.util.Set;

import org.springframework.data.annotation.Id;

public class MongoUser {
    @Id
    private String id;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    private String firstName;
    private String lastName;
    private Set< String > roles;

    public MongoUser() {
    }

    public Set< String > getRoles( ) {
        return roles;
    }

    public void setRoles( Set< String > roles ) {
        this.roles = roles;
    }

    public String getId( ) {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public String getFirstName( ) {
        return firstName;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    public String getLastName( ) {
        return lastName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }
}
