package com.company.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final RestTest test;

    public Controller(RestTest test) {
        this.test = test;
    }

    @GetMapping
    public String hello() {
        return "hello";
    }
}
