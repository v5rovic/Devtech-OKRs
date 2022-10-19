package com.petrovic.demo;

import com.petrovic.demo.security.RsaKeyProperties;
import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableMongock
@EnableConfigurationProperties(RsaKeyProperties.class)
public class DemoProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoProjectApplication.class, args);
    }

}
