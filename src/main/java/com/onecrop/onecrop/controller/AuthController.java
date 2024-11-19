package com.onecrop.onecrop.controller;

import com.onecrop.onecrop.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@Getter
@Setter
public class AuthController {

    private final UserRepository userRepository;


    @PostMapping("/register")
    public String register(@RequestBody User user) {}



}
