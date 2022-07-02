package com.example.assignment.services.impl;

import com.example.assignment.data.entities.Account;
import com.example.assignment.data.repositories.AccountRepository;
import com.example.assignment.dto.response.AccountResponseDTO;
import com.example.assignment.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.assignment.services.AccountService;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountServiceImpl(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Account> getAllAccounts() {
        return this.accountRepository.findAll();
    }

    @Override
    public AccountResponseDTO getAccountById(Long id) {
        return modelMapper.map(
                this.accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account Not Found")),
                AccountResponseDTO.class);
    }

    @Override
    public AccountResponseDTO changeAccountStatus(AccountResponseDTO dto) {
//        accountRepository.changeUserAccountStatus(
//                dto.getId(),
//                dto.getEnabled()
//        );
        Account updatedAccount = accountRepository.findById(dto.getId())
                .orElseThrow( () -> new ResourceNotFoundException(
                        String.format("User account with ID: %s not found", dto.getId())
                ));
        return modelMapper.map(updatedAccount, AccountResponseDTO.class);
    }
}
