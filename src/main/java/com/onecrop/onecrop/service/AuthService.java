package com.onecrop.onecrop.service;

import com.onecrop.onecrop.dto.LoginDto;
import com.onecrop.onecrop.dto.UserRequestDto;
import com.onecrop.onecrop.dto.UserResponseDto;
import com.onecrop.onecrop.exception.EntityDoesntExistException;
import com.onecrop.onecrop.mapper.UserMapper;
import com.onecrop.onecrop.model.User;
import com.onecrop.onecrop.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AuthService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private UserMapper userMapper;
    private UserService userService;

    public UserResponseDto register(UserRequestDto userRequestDto) {
        if(!userRequestDto.getRole().equalsIgnoreCase("buyer") && !userRequestDto.getRole().equalsIgnoreCase("seller")) {
            throw new EntityDoesntExistException("Role not found");
        }

        return userService.save(userRequestDto);
    }

    public void login(LoginDto loginRequest, HttpServletRequest request) {
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

    public UserResponseDto profile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userRepository.findByUsername(authentication.getName()).orElseThrow();
        return userMapper.userEntitytoUserResponseDto(currentUser);
    }

    public void logout(HttpServletRequest request) {
        SecurityContextHolder.clearContext();
        request.getSession().invalidate();
    }
}
