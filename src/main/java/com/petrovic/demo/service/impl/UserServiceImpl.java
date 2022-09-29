package com.petrovic.demo.service.impl;

import com.petrovic.demo.dto.UserDto;
import com.petrovic.demo.model.User;
import com.petrovic.demo.repository.UserRepo;
import com.petrovic.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepo userRepo;

  @Override
  public UserDto findUserByEmail(String email) {
    User user = userRepo.findByEmail(email);
    if (user != null) {
      log.info("User with email: {} found!",email);
      return UserDto.fromUser(user);
    }
    log.info("User with email: {} not found!", email);
    throw new RuntimeException(String.format("User with email: %s not found!", email));
  }

  @Override
  public String saveUser(UserDto dto) {
    if(!userRepo.existsByEmail(dto.email())){
      userRepo.save(UserDto.toUser(dto));
      log.info("User with mail {} has been saved!", dto.email());
      return dto.email();
    }
    log.info("User with this mail {} exist!", dto.email());
    return String.format("User with this mail %s exist!", dto.email());
  }

  @Override
  public boolean existByEmail(String email) {
    return userRepo.existsByEmail(email);
  }
}
