package com.onecrop.onecrop.dto;

import com.onecrop.onecrop.model.Address;
import com.onecrop.onecrop.model.Role;
import com.onecrop.onecrop.model.Wallet;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class UserResponseDto {

    private UUID id;

    private String email;

    private String username;

    private String firstName;

    private String lastName;

    private Role role;

    private Address address;

    private Wallet wallet;

}
