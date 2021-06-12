package com.nuwe.controller;


import com.nuwe.entity.User;
import com.nuwe.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserServiceImpl userServiceImpl;


  @GetMapping("/{id}")
  @ResponseBody
  public User getUserById(@PathVariable("id") String id) {
    return userServiceImpl.getUserById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteUserById(@PathVariable("id") String id) {
    userServiceImpl.deleteUserById(id);
  }
}