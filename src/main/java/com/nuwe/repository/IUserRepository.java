package com.nuwe.repository;
import com.nuwe.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface IUserRepository extends MongoRepository<User, String> {

    User getUserById(String id);
}
