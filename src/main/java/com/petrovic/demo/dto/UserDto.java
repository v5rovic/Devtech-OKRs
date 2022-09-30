package com.petrovic.demo.dto;

import com.petrovic.demo.model.Role;
import com.petrovic.demo.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public record UserDto(String email, String firstName, String lastName, String password, Role role) {

  public static User toUser(UserDto dto, boolean encryptPassword) {
    if (encryptPassword) {
      return new User(dto.email, dto.firstName, dto.lastName, new BCryptPasswordEncoder().encode(dto.password), dto.role);
    }
    return new User(dto.email, dto.firstName, dto.lastName, dto.password, dto.role);
  }

  public static UserDto fromUser(User user) {
    return new UserDto(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword(),
        user.getRole());
  }



}
