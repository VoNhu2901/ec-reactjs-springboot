package com.example.assignment.services;

import com.example.assignment.dto.request.RegisterRequestDto;
import com.example.assignment.dto.request.SignInRequestDto;
import com.example.assignment.dto.response.AuthResponseDto;

public interface AuthService {
    public AuthResponseDto signIn(SignInRequestDto dto);

    public AuthResponseDto registerUser(RegisterRequestDto dto);
}
