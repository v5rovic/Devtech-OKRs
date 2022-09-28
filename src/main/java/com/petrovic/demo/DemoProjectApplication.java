package com.petrovic.demo;

import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableMongock
public class DemoProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoProjectApplication.class, args);
    }

}
