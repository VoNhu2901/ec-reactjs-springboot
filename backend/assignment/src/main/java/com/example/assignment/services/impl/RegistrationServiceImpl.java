package com.example.assignment.services.impl;

import com.example.assignment.config.EmailValidation;
import com.example.assignment.config.TestBuildEmail;
import com.example.assignment.data.entities.ConfirmationToken;
import com.example.assignment.data.repositories.UserRepository;
import com.example.assignment.dto.request.RegistrationRequest;
import com.example.assignment.dto.response.RegistrationResponse;
import com.example.assignment.exceptions.BadRequestException;
import com.example.assignment.exceptions.ResourceNotFoundException;
import com.example.assignment.services.ConfirmationTokenService;
import com.example.assignment.services.EmailSender;
import com.example.assignment.services.RegistrationService;
import com.example.assignment.utils.AppUserRole;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final EmailValidation emailValidation;
    private final UserServiceImpl userServiceImpl;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;


    @Override
    public String register(RegistrationRequest registrationRequest) {
        boolean isValidEmail = emailValidation.apply(registrationRequest.getEmail());
        if (!isValidEmail) {
            throw new IllegalArgumentException("Invalid email");
        }
        String token = userServiceImpl.signUpUser(
                new UserDetailsImpl(
                        registrationRequest.getFirstName(),
                        registrationRequest.getLastName(),
                        registrationRequest.getEmail(),
                        registrationRequest.getPassword(),
                        AppUserRole.USER));

                        String link = "http://localhost:8080/api/v1/registration/confirm?token=" + token;
        emailSender.send(registrationRequest.getEmail(), TestBuildEmail.buildEmail(registrationRequest.getFirstName(), link));
        return token;
    }
    
    
    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService.getToken(token).isPresent()
                ? confirmationTokenService.getToken(token).get()
                : null;
        
        if (confirmationToken == null) {
            throw new ResourceNotFoundException("Confirmation token not found");
        }

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiredAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        userServiceImpl.enableAppUser(confirmationToken.getUser().getEmail());
        return "confirmed";
    }

}
