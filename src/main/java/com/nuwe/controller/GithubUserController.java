package com.nuwe.controller;

import com.nuwe.entity.GithubUser;
import com.nuwe.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/github")
public class GithubUserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    //enter a github username and get GithubUser info
    @GetMapping("/{username}")
    public GithubUser getGithubUserByUsername(@PathVariable("username") String username) {
        return userServiceImpl.getGithubUserByUsername(username);
    }
}
