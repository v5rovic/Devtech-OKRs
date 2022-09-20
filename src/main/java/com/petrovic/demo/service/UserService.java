package com.petrovic.demo.service;

import com.petrovic.demo.dto.UserDto;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface UserService {

  UserDto findUserByEmail(String email) throws NotFoundException;

  String saveUser(UserDto user);

  boolean existByEmail(String email);

}
