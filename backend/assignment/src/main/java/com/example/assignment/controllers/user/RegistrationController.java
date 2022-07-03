package com.example.assignment.controllers.user;

import com.example.assignment.services.RegistrationService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import com.example.assignment.dto.request.RegistrationRequest;

@RestController
@RequestMapping("/api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

  private final RegistrationService registrationService;

  @PostMapping
  public String register(@RequestBody RegistrationRequest registrationRequest) {
    return registrationService.register(registrationRequest);
  }

  @GetMapping(path = "confirm")
  public String confirm(@RequestParam("token") String token) {
    return registrationService.confirmToken(token);
  }

}
