package com.example.assignment.services.impl;

import com.example.assignment.data.repositories.AccountRepository;
import com.example.assignment.dto.request.RegistrationRequest;
import com.example.assignment.services.RegisterService;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    private AccountRepository accountRepository;


    @Override
    public String register(RegistrationRequest registrationRequest) {
        return null;
    }
}
