package com.onecrop.onecrop.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginDto {

        @NotEmpty(message = "Username is required")
        @Size(min = 3, message = "Username length must be at least 3 characters")
        private String username;

        @NotEmpty(message = "password is required")
        private String password;
}
