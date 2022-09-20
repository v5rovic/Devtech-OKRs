package com.petrovic.demo.dto;

import com.petrovic.demo.model.Role;
import com.petrovic.demo.model.User;

public record UserDto(String email, String firstName, String lastName, String password, Role role) {

  public static User toUser(UserDto dto) {
    return new User(dto.email, dto.firstName, dto.lastName, dto.password, dto.role);
  }

  public static UserDto fromUser(User user) {
    return new UserDto(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword(),
        user.getRole());
  }

}
