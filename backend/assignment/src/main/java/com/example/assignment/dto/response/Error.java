package com.example.assignment.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class Error {
    private String code;
    private String message;
    @JsonInclude(Include.NON_NULL)
    Map<String, String> validationErrors;
    

    public Error(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public Error(String code, String message, Map<String, String> validationErrors) {
        this.code = code;
        this.message = message;
        this.validationErrors = validationErrors;
    }


}
