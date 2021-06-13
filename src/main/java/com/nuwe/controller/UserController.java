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

  //get a user by id
  @GetMapping("/{id}")
  public User getUserById(@PathVariable("id") String id) {
    return userServiceImpl.getUserById(id);
  }

  //delete a user by id
  @DeleteMapping("/{id}")
  public void deleteUserById(@PathVariable("id") String id) {
    userServiceImpl.deleteUserById(id);
  }

  //edit name, username, password and/or email of a user by id
  @PutMapping("/{id}")
  public ResponseEntity<Object> editUser(@RequestBody User user, @PathVariable("id") String id){
    try {
      return ResponseEntity.ok().body(userServiceImpl.editUser(user, id));
    }catch(Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause());
    }
  }

  //create a new user
  @PostMapping
  public User createUser(@RequestBody User user) {
    return userServiceImpl.save(user);
  }

}