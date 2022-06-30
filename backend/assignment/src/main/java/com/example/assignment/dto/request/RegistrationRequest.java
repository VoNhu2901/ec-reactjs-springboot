package com.example.assignment.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// @NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {
  @NotBlank(message = "firstName is required")
  private final String firstName;

  @NotBlank(message = "lastName is required")
  private final String lastName;

  @NotBlank(message = "email is required")
  private final String email;

  @NotBlank(message = "password is required")
  private final String password;

  private String matchingPassword;

}
