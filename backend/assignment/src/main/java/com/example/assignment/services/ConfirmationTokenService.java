package com.example.assignment.services;

import com.example.assignment.data.entities.ConfirmationToken;
import com.google.common.base.Optional;

public interface ConfirmationTokenService {

  void saveConfirmToken(ConfirmationToken confirmToken);

  int setConfirmedAt(String token);

  Optional<ConfirmationToken> getToken(String token);

  
}
