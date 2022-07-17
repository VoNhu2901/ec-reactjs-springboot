package com.example.assignment.exceptions.handlers;

import com.example.assignment.exceptions.ResourceAlreadyExistsException;
import com.example.assignment.exceptions.ResourceNotFoundException;
import com.example.assignment.exceptions.Unauthorized;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionsHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ResourceNotFoundException.class})
    protected MessageResponse handleResourceNotFoundException(RuntimeException exception, WebRequest req) {
        return new MessageResponse(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler({ResourceAlreadyExistsException.class})
    protected MessageResponse handleResourceAlreadyExistsException(RuntimeException exception,
                                                                   WebRequest request) {
        return new MessageResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler({Unauthorized.class})
    protected MessageResponse handleForbiddenException(RuntimeException exception,
                                                       WebRequest request) {
        return new MessageResponse(HttpStatus.FORBIDDEN, exception.getMessage());
    }

    @ExceptionHandler({IllegalArgumentException.class})
    protected MessageResponse handleIllegalArgumentException(RuntimeException exception, WebRequest request) {
        return new MessageResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders header, HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((err) -> {
            String field = ((FieldError) err).getField();
            String message = err.getDefaultMessage();
            errors.put(field, message);
        });

        return new ResponseEntity<Object>(new MessageResponse(HttpStatus.BAD_REQUEST, exception.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

}
