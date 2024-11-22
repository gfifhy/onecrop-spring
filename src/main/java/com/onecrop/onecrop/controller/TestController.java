package com.onecrop.onecrop.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
public class TestController {

    @GetMapping("/user/test")
    public List<String> userTest() {
        return new LinkedList<>(Arrays.asList("a", "b", "c"));
    }


    @GetMapping("/user/welcome")
    public String userWelcome() {
        return "Welcome to onecrop";
    }


    @GetMapping("/admin/test")
    public List<String> adminTest() {
        return new LinkedList<>(Arrays.asList("a", "b", "c"));
    }


    @GetMapping("/admin/welcome")
    public String adminWelcome() {
        return "Welcome to onecrop: ADMIN";
    }
}
