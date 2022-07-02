package com.example.assignment.services;

import com.example.assignment.dto.request.AccountUpdateDTO;
import com.example.assignment.dto.response.AccountResponseDTO;

public interface RegisterService {

    AccountResponseDTO register(AccountUpdateDTO dto);
}
