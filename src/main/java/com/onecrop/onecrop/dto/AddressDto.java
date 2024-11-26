package com.onecrop.onecrop.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

    @NotEmpty(message = "Street must not be empty")
    private String street;

    private String addressLine2;

    @NotEmpty(message = "Barangay must not be empty")
    private String barangay;

    @NotEmpty(message = "City must not be empty")
    private String city;

    @NotEmpty(message = "Region must not be empty")
    private String region;

    @NotEmpty(message = "Street must not be empty")
    private String postalCode;
}
