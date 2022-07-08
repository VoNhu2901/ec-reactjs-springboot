package com.example.assignment.exceptions.handlers;

import com.example.assignment.exceptions.ForbiddenException;
import com.example.assignment.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionsHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> resourceNotFoundHandling(ResourceNotFoundException exception, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> globalExceptionHandling(Exception exception, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ForbiddenException.class})
    public ResponseEntity<Object> forbiddenExceptionHandling(ForbiddenException forbiddenException, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(new Date(), forbiddenException.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }
}
