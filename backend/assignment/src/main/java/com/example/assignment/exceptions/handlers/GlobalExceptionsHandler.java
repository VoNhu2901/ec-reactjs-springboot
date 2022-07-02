package com.example.assignment.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.assignment.dto.response.ErrorResponse;
import com.example.assignment.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionsHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({ ResourceNotFoundException.class })
  protected ResponseEntity<ErrorResponse> handleResourceNotFoundException(RuntimeException exception,
      WebRequest request) {
    ErrorResponse error = new ErrorResponse("404", exception.getMessage());
    return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({ IllegalArgumentException.class })
  protected ResponseEntity<ErrorResponse> handleIllegalArgumentException(RuntimeException exception,
      WebRequest request) {
    ErrorResponse error = new ErrorResponse("400", exception.getMessage());
    return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
  }

  // @ExceptionHandler({ MethodArgumentNotValidException.class })
  // protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
  //     MethodArgumentNotValidException exception, WebRequest request) {
  //   Map<String, String> errors = new HashMap<>();
  //   exception.getBindingResult().getFieldErrors().forEach(error -> {
  //     errors.put(error.getField(), error.getDefaultMessage());
  //   });
  //   ErrorResponse error = new ErrorResponse("400", errors);
  //   return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
  // }

  @ExceptionHandler({ Exception.class })
  protected ResponseEntity<ErrorResponse> handleException(RuntimeException exception, WebRequest request) {
    ErrorResponse error = new ErrorResponse("500", exception.getMessage());
    return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }


  // @Override
  // protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
  //     HttpHeaders headers, HttpStatus status, WebRequest request) {
  //   Map<String, String> errors = new HashMap<>();
  //   ex.getBindingResult().getAllErrors().forEach((error) -> {
  //     String fieldName = ((FieldError) error).getField();
  //     String errorMessage = error.getDefaultMessage();
  //     errors.put(fieldName, errorMessage);
  //   });
  //   ErrorResponse error = new ErrorResponse("400", "Validation Error", errors);
  //   return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
  // }

}
