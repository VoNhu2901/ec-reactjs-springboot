package com.example.assignment.services;

import com.example.assignment.data.entities.Account;
import com.example.assignment.dto.response.AccountResponseDTO;

import java.util.List;

public interface AccountService {


    List<Account> getAllAccounts();

    AccountResponseDTO getAccountById(Long id);

    AccountResponseDTO changeAccountStatus(AccountResponseDTO dto);
}
