package com.onecrop.onecrop.mapper;


import com.onecrop.onecrop.dto.UserRequestDto;
import com.onecrop.onecrop.dto.UserResponseDto;
import com.onecrop.onecrop.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User userRequestDtotoUserEntity(UserRequestDto user){
        User userEntity = new User();
        userEntity.setEmail(user.getEmail());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setAvatarUrl(user.getAvatarUrl());
        userEntity.setContactNumber(user.getContactNumber());

        return userEntity;
    }
    public UserResponseDto userEntitytoUserResponseDto(User user){
        UserResponseDto userResponse = new UserResponseDto();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setUsername(user.getUsername());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setRole(user.getRole());
        userResponse.setAddress(user.getAddress());
        userResponse.setWallet(user.getWallet());
        return userResponse;
    }
}
