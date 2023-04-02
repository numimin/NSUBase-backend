package com.github.numi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@RestController
public class NSUBaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(com.github.numi.NSUBaseApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return String.format("Hello, %s!", name);
    }
}
