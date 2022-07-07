package com.example.assignment.controllers;

import com.example.assignment.dto.request.RegisterRequestDto;
import com.example.assignment.dto.request.SignInRequestDto;
import com.example.assignment.dto.response.AuthResponseDto;
import com.example.assignment.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/signin")
    public AuthResponseDto signIn(@RequestBody SignInRequestDto dto) {
        return this.authService.signIn(dto);
    }


    @PostMapping("/register")
    public AuthResponseDto registerUser(@RequestBody RegisterRequestDto dto) {
        return this.authService.registerUser(dto);
    }
}
