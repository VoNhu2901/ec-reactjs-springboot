package com.example.assignment.services;

import com.example.assignment.dto.request.RegisterRequestDto;
import com.example.assignment.dto.response.AccountResponseDto;
import com.example.assignment.exceptions.handlers.MessageResponse;

import java.util.List;

public interface AccountService {
    public List<AccountResponseDto> getAllAccount();

    public AccountResponseDto getAccountById(int id);

    public MessageResponse deleteAccount(int id);

    public MessageResponse updateAccount(int id, RegisterRequestDto dto);

}
