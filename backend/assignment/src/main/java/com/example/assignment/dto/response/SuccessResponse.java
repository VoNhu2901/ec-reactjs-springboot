package com.example.assignment.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class SuccessResponse {
    HttpStatus status;
    String message;


    public SuccessResponse(HttpStatus status, String message) {
        this.message = message;
        this.status = status;
    }


}
