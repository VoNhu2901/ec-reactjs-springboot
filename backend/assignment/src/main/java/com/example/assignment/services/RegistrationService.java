package com.example.assignment.services;

import com.example.assignment.dto.request.RegistrationRequest;

public interface RegistrationService {

  String register(RegistrationRequest registrationRequest);

  String confirmToken(String token);

}
