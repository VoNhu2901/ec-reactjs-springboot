package com.example.assignment.services;

import com.example.assignment.dto.request.RegisterRequestDto;
import com.example.assignment.dto.response.AccountResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {
    public List<AccountResponseDto> getAllAccount();

    public AccountResponseDto getAccountById(int id);

    public ResponseEntity<?> deleteAccount(int id);

    public ResponseEntity<?> updateAccount(int id, RegisterRequestDto dto);
}
