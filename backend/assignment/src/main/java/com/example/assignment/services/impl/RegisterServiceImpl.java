package com.example.assignment.services.impl;

import com.example.assignment.data.entities.Account;
import com.example.assignment.data.repositories.AccountRepository;
import com.example.assignment.dto.request.AccountUpdateDTO;
import com.example.assignment.dto.request.RegistrationRequest;
import com.example.assignment.dto.response.AccountResponseDTO;
import com.example.assignment.services.RegisterService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    private AccountRepository accountRepository;
    private final ModelMapper modelMapper;


    public RegisterServiceImpl(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AccountResponseDTO register( AccountUpdateDTO dto) {
        Account account = modelMapper.map(dto, Account.class);
        Account saveAccount = accountRepository.save(account);
        return modelMapper.map(saveAccount, AccountResponseDTO.class);
    }
}
