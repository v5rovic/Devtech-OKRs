package com.petrovic.demo.service.impl;

import com.petrovic.demo.dto.UserDto;
import com.petrovic.demo.model.User;
import com.petrovic.demo.repository.UserRepo;
import com.petrovic.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepo userRepo;
  @Override
  public UserDto findUserByEmail(String email) throws NotFoundException {
    User user = userRepo.findByEmail(email);
    if (user != null) {
      log.info("User with email: {} found!",email);
      return UserDto.fromUser(user);
    }
    log.info("User with email: {} not found!", email);
    return null;
  }

  @Override
  public String saveUser(UserDto dto) {
    if(userRepo.findByEmail(dto.email()) == null){
      userRepo.save(UserDto.toUser(dto));
    }

    return dto.email();
  }

  @Override
  public boolean existByEmail(String email) {
    return userRepo.existsByEmail(email);
  }
}
