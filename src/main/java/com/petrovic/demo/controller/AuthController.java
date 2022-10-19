package com.petrovic.demo.controller;

import com.petrovic.demo.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
@RequiredArgsConstructor
public class AuthController {

    private final TokenService tokenService;

    @GetMapping
    public ResponseEntity<String> getToken(Authentication authentication){
        return new ResponseEntity<>(tokenService.generateToken(authentication), HttpStatus.OK);
    }

}
