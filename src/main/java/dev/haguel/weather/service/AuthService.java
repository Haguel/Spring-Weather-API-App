package dev.haguel.weather.service;

import dev.haguel.weather.dto.SignInUserDTO;
import dev.haguel.weather.dto.SignUpUserDTO;
import dev.haguel.weather.model.User;
import dev.haguel.weather.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public void signIn(SignInUserDTO signInUserDTO){
        User existedUser = userRepository.findByEmail(signInUserDTO.email());

        if(existedUser == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with this email doesn't exist.");
        }

        boolean isPasswordMatches = passwordEncoder.matches(signInUserDTO.password(), existedUser.getPasswordHash());

        if(!isPasswordMatches) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Wrong password or email.");
        }
    }

    public void signUp(SignUpUserDTO signUpUserDTO) {
        User existedUser = userRepository.findByEmail(signUpUserDTO.email());

        if(existedUser != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This email is already taken.");
        }

        String passwordHash = passwordEncoder.encode(signUpUserDTO.password());

        User newUser = new User();
        newUser.setEmail(signUpUserDTO.email());
        newUser.setPasswordHash(passwordHash);

        userRepository.save(newUser);
    }
}
