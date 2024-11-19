package com.onecrop.onecrop.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
public class Test {

    @GetMapping("/test")
    public List<String> test() {
        return new LinkedList<>(Arrays.asList("a", "b", "c"));
    }
}
