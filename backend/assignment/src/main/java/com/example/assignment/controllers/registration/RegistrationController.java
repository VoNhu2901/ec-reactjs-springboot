package com.example.assignment.controllers.registration;

import javax.validation.Valid;

import com.example.assignment.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.assignment.dto.request.RegistrationRequest;


@RestController
 @RequestMapping("/api/v1")
public class RegistrationController {

//   private static final String USER_ROLE = "USER";

  @Autowired
  private final RegisterService registerService;

  public RegistrationController(RegisterService registerService) {
    this.registerService = registerService;
  }

  @PostMapping("/register")
  @ResponseStatus(HttpStatus.CREATED)
  public String register(@Valid @RequestBody RegistrationRequest registrationRequest) {
    return this.registerService.register(registrationRequest);
  }

}
