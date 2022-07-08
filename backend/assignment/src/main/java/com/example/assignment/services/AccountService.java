package com.example.assignment.services;

import com.example.assignment.dto.request.RegisterRequestDto;
import com.example.assignment.dto.response.AccountResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {
    List<AccountResponseDto> getAllAccount();

    AccountResponseDto getAccountById(int id);

    ResponseEntity<?> deleteAccount(int id);

    ResponseEntity<?> updateAccount(int id, RegisterRequestDto dto);
}
