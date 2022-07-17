package com.example.assignment.services;

import com.example.assignment.dto.request.RegisterRequestDto;
import com.example.assignment.dto.request.SignInRequestDto;
import com.example.assignment.dto.response.AuthResponseDto;

public interface AuthService {
    AuthResponseDto signIn(SignInRequestDto dto);

    AuthResponseDto registerUser(RegisterRequestDto dto);
}
