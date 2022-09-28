package com.petrovic.demo.model;

import lombok.Getter;

@Getter
public enum Role {
  ADMIN("ADMIN"),
  USER("USER");

  private final String name;

  Role(String name) {
    this.name = name;
  }
}
