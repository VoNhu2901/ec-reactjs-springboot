package com.example.assignment.services;

import com.example.assignment.dto.request.RegisterRequestDto;
import com.example.assignment.dto.response.AccountResponseDto;
import com.example.assignment.exceptions.handlers.MessageResponse;

import java.util.List;

public interface AccountService {
    List<AccountResponseDto> getAllAccount();

    AccountResponseDto getAccountById(int id);

    MessageResponse deleteAccount(int id);

    MessageResponse updateAccount(int id, RegisterRequestDto dto);

}
