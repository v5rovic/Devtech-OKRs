package com.petrovic.demo.model;

public enum Role {
  ADMIN("ADMIN"),
  USER("USER");

  private String name;

  Role(String name) {
    this.name = name;
  }
}
