package com.onecrop.onecrop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequestDto {
        @Email
        @NotEmpty(message = "email is required")
        private String email;

        @NotEmpty(message = "Username is required")
        @Size(min = 3, message = "Username length must be at least 3 characters")
        private String username;

        @NotEmpty(message = "password is required")
        @Size(min = 8, message = "Password length must be at least 8 characters")
        private String password;

        @NotEmpty(message = "firstname is required")
        private String firstName;

        @NotEmpty(message = "lastname is required")
        private String lastName;

        @NotEmpty
        private String role;

}
