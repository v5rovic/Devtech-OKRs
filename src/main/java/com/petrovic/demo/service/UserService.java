package com.petrovic.demo.service;

import com.petrovic.demo.dto.UserDto;

public interface UserService {

  UserDto findUserByEmail(String email);

  String saveUser(UserDto user);

  boolean existByEmail(String email);

}
