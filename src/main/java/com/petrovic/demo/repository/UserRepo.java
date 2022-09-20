package com.petrovic.demo.repository;

import com.petrovic.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

  User findByEmail(String email);

  boolean existsByEmail(String email);
}
