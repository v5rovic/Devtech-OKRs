package com.petrovic.demo.controller;

import com.petrovic.demo.dto.UserDto;
import com.petrovic.demo.model.User;
import com.petrovic.demo.repository.UserRepo;
import com.petrovic.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;
  private final UserRepo repo;

  @GetMapping("/{email}")
  public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
    UserDto user = userService.findUserByEmail(email);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<String> saveUser(@RequestBody UserDto dto) {
    String email = userService.saveUser(dto);
    return new ResponseEntity<>(email, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<User>> getUsers() {
    List<User> users = repo.findAll();
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @DeleteMapping("/all")
  public ResponseEntity<Void> deleteUsers() {
    repo.deleteAll();
    return new ResponseEntity<>(HttpStatus.OK);
  }

}