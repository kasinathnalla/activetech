package com.arkiv.sports.referee.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.arkiv.sports.referee.service.UserService;

/**
 * Created by knalla on 1/21/17.
 */
@RestController
public class HelloRest {

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/getDonationList", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String getComments() {

        return userService.save().getFirstName();
    }
}
