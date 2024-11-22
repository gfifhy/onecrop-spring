package com.onecrop.onecrop.controller;

import com.onecrop.onecrop.dto.LoginDto;
import com.onecrop.onecrop.dto.UserRequestDto;
import com.onecrop.onecrop.dto.UserResponseDto;
import com.onecrop.onecrop.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@Valid @RequestBody UserRequestDto user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }


    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public void login(@Valid @RequestBody LoginDto loginRequest, HttpServletRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            request.getSession().setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid username or password");
        }
    }

    @GetMapping("/session")
    public String getSession(HttpSession session) {
        // Get the session ID
        String sessionId = session.getId();
        return "Session ID: " + sessionId;
    }

    @GetMapping("/debug/user")
    public Map<String, Object> getCurrentUser(HttpServletRequest request) {
        // Retrieve authentication object
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Extract session token
        String sessionId = request.getSession().getId();

        // Prepare response
        Map<String, Object> response = new HashMap<>();
        response.put("username", authentication.getName());
        response.put("authorities", authentication.getAuthorities());
        response.put("sessionToken", sessionId);

        return response;
    }
}
