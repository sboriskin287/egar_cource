package com.egar.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping
    public String hello() {
        return "hello";
    }

    @GetMapping ("/user")
    public String user() {
        return "user";
    }
}
