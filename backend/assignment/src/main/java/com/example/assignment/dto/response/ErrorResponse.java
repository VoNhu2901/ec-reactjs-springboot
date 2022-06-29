package com.example.assignment.dto.response;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
  String code;
  String message;
  @JsonInclude(Include.NON_NULL)
  Map<String, String> validationErrors;

  public ErrorResponse(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public ErrorResponse(String code2, Map<String, String> errors) {
  }
}
