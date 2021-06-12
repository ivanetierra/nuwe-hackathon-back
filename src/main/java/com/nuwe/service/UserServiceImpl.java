package com.nuwe.service;

import com.nuwe.entity.User;
import com.nuwe.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService {

  @Autowired
  IUserRepository iUserRepository;

  @Override
  public User getUserById(String id) {
    return iUserRepository.getUserById(id);
  }

  public void deleteUserById(String id) {
    iUserRepository.deleteById(id);
  }
}
