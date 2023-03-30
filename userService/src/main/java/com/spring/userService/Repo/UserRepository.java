package com.spring.userService.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.userService.model.User;


@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
