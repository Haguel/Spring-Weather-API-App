package dev.haguel.weather.controller;

import dev.haguel.weather.dto.SignInUserDTO;
import dev.haguel.weather.dto.SignUpUserDTO;
import dev.haguel.weather.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/signin")
    public void signIn(@Valid @RequestBody SignInUserDTO signInUserDTO) {
        authService.signIn(signInUserDTO);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@Valid @RequestBody SignUpUserDTO signUpUserDTO) {
        authService.signUp(signUpUserDTO);
    }
}
