package com.example.assignment.controllers.user;

import javax.validation.Valid;

import com.example.assignment.data.entities.Actor;
import com.example.assignment.dto.request.AccountUpdateDTO;
import com.example.assignment.dto.response.AccountResponseDTO;
import com.example.assignment.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.assignment.dto.request.RegistrationRequest;

import java.util.List;


@RestController
 @RequestMapping("/api/v1/register")
public class RegistrationController {

//   private static final String USER_ROLE = "USER";

  @Autowired
  private final RegisterService registerService;

  public RegistrationController(RegisterService registerService) {
    this.registerService = registerService;
  }

//  @GetMapping
//  List<Actor> getAllAccounts() {
//    return this.registerService.getAllAccounts();
//  }

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  AccountResponseDTO register(@Valid @RequestBody AccountUpdateDTO dto) {
    return this.registerService.register(dto);
  }

}
