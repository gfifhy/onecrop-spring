package com.onecrop.onecrop.controller;

import com.onecrop.onecrop.dto.LoginDto;
import com.onecrop.onecrop.dto.UserRequestDto;
import com.onecrop.onecrop.dto.UserResponseDto;
import com.onecrop.onecrop.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@Valid @RequestBody UserRequestDto user){
        return new ResponseEntity<>(authService.register(user), HttpStatus.CREATED);
    }


    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public void login(@Valid @RequestBody LoginDto loginRequest, HttpServletRequest request) {
        authService.login(loginRequest, request);
    }


    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<UserResponseDto> profile() {
        return new ResponseEntity<>(authService.profile(), HttpStatus.OK);
    }

    @PostMapping("/logout")
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    public void logout(HttpServletRequest request) {
        authService.logout(request);
    }




    // DEBUG PURPOSES ONLY
    @GetMapping("/debug/user")
    public Map<String, Object> getCurrentUser(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String sessionId = request.getSession().getId();

        Map<String, Object> response = new HashMap<>();
        response.put("username", authentication.getName());
        response.put("authorities", authentication.getAuthorities());
        response.put("sessionToken", sessionId);
        response.put("isAuthenticated()", authentication.isAuthenticated());

        return response;
    }
}
