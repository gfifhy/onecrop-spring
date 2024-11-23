package com.onecrop.onecrop.service;

import com.onecrop.onecrop.dto.UserRequestDto;
import com.onecrop.onecrop.dto.UserResponseDto;
import com.onecrop.onecrop.exception.EntityDoesntExistException;
import com.onecrop.onecrop.exception.EntityExistException;
import com.onecrop.onecrop.mapper.UserMapper;
import com.onecrop.onecrop.model.Role;
import com.onecrop.onecrop.model.User;
import com.onecrop.onecrop.repository.RoleRepository;
import com.onecrop.onecrop.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@RequestMapping("/auth")
@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    public Page<User> getAllUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }

    public UserResponseDto update(UUID id, User user) {
        if (!userRepository.existsById(id)) {
            throw new EntityDoesntExistException("User not found with id: " + id);
        }
        user.setId(id);
        return userMapper.userEntitytoUserResponseDto(userRepository.save(user));
    }

    public UserResponseDto save(@RequestBody UserRequestDto user) {
        User userEntity = userMapper.userRequestDtotoUserEntity(user);
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));

        Optional<Role> role= roleRepository.findByName(user.getRole());
        if(role.isEmpty()) {
            var userRole = roleRepository.findByName("ROLE_BUYER").orElseThrow(() ->
                    new EntityDoesntExistException("Role not found: "));
            userEntity.setRole(userRole);
        }
        else {
            userEntity.setRole(role.get());
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EntityExistException("Email already exists.");
        }

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new EntityExistException("Username already exists.");
        }

        User savedUser = userRepository.save(userEntity);
        return userMapper.userEntitytoUserResponseDto(savedUser);
    }
    public UserResponseDto getUserById(UUID id) {
        return userMapper.userEntitytoUserResponseDto(
                userRepository
                        .findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("User not found with id: " + id)
                        )
        );
    }

    public void delete(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new EntityDoesntExistException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

}
