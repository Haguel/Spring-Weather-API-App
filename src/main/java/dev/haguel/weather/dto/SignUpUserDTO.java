package dev.haguel.weather.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignUpUserDTO(
        @NotBlank(message = "Email can't be blank.")
        @Email(message = "Invalid email. Please, provide correct email address.")
        String email,

        @NotBlank(message = "Password can't be blank.")
        @Size(min = 8, message = "Password size must be minimum 8 characters.")
        String password
) {
}
