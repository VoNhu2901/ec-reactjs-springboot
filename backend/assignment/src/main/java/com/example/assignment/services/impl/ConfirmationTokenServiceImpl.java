package com.example.assignment.services.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.assignment.data.entities.ConfirmationToken;
import com.example.assignment.data.repositories.ConfirmationTokenRepository;
import com.example.assignment.services.ConfirmationTokenService;
import com.google.common.base.Optional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {

  private final ConfirmationTokenRepository confirmTokenRepository;

  public void saveConfirmToken(ConfirmationToken confirmToken) {
    confirmTokenRepository.save(confirmToken);
  }

  @Override
  public int setConfirmedAt(String token) {
    return confirmTokenRepository.updateConfirmedAt(
        token,
        LocalDateTime.now());
    // return 0;
  }

  @Override
  public Optional<ConfirmationToken> getToken(String token) {
    return confirmTokenRepository.findByToken(token);
  }

  
}
