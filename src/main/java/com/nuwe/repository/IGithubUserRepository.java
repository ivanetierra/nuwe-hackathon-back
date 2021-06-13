package com.nuwe.repository;
import com.nuwe.entity.GithubUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IGithubUserRepository extends MongoRepository<GithubUser, String> {

}
