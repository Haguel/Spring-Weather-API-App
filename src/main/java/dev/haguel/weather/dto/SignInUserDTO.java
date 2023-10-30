package dev.haguel.weather.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SignInUserDTO(
        @NotBlank(message = "Email can't be blank.")
        @Email(message = "Invalid email. Please, provide correct email address.")
        String email,

        @NotBlank(message = "Password can't be blank.")
        String password
) {
}
