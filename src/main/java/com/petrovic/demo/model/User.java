package com.petrovic.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class User {

  @Indexed(unique = true, background = true)
  private String email;
  private String firstName;
  private String lastName;
  private String password;
  private Role role;

}
