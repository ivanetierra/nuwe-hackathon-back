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

    user.setFormat_valid(checkEmail(user.getEmail())); //check new email before saving user
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
      String apiKey = "369a7a1b4f6a2462bac5f1d92e56361f";

      String url = "http://apilayer.net/api/check?access_key="+apiKey+"&email="+email+"&smtp=1&format=1";

      RestTemplate restTemplate = new RestTemplate();

      //String result = restTemplate.getForObject(url, String.class);
      //System.out.println(result);

      User user = restTemplate.getForObject(url, User.class);
      iUserRepository.save(user);
      return user.getFormat_valid();
    }
}
