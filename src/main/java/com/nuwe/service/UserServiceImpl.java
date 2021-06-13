package com.nuwe.service;

import com.nuwe.entity.GithubUser;
import com.nuwe.exceptions.*;
import com.nuwe.entity.User;
import com.nuwe.repository.IGithubUserRepository;
import com.nuwe.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;


@Service
public class UserServiceImpl implements IUserService {

  @Autowired
  IUserRepository iUserRepository;

  @Autowired
  IGithubUserRepository iGithubUserRepository;

  @Override
  public User getUserById(String id) {
    return iUserRepository.getUserById(id);
  }

  public void deleteUserById(String id) {
    iUserRepository.deleteById(id);
  }

  public User editUser(User user,String id) {
    User myUser = iUserRepository.findById(id).get();
    myUser.setName(user.getName());
    myUser.setUsername(user.getUsername());
    myUser.setEmail(user.getEmail());
    myUser.setPassword(user.getPassword());

    return iUserRepository.save(myUser);

  }


  public User save(User user) {
    if (iUserRepository.existsByUsername(user.getUsername())) {
      throw new UserExistsException(user.getUsername());
    } else if (iUserRepository.existsByEmail(user.getEmail())) {
      throw new EmailExistsException(user.getEmail());
    } else {
      user.setFormat_valid(checkEmail(user.getEmail()));
      return iUserRepository.save(user);
    }
  }

  public GithubUser getGithubUserByUsername(String username) {

    String url = "https://api.github.com/users/" + username;

    RestTemplate restTemplate = new RestTemplate();
    GithubUser githubUser  = restTemplate.getForObject(url, GithubUser.class);

    iGithubUserRepository.save(githubUser);

    return githubUser;
  }


    public boolean checkEmail(String email) {

      String apiKey = "ef91dabc791d89a28a14d1165a329cfc";
      String url = "http://apilayer.net/api/check ? access_key = " + apiKey + "& email  = "+email+"& format = 1";

      RestTemplate restTemplate = new RestTemplate();
      boolean isValid = restTemplate.getForObject(url, User.class).getFormat_valid();
      return isValid;

    }
}
