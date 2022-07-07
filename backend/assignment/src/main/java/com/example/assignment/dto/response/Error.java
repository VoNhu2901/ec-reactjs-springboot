package com.example.assignment.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Map;

public class Error {
    private String code;
    private String message;
    @JsonInclude(Include.NON_NULL)
    Map<String, String> validationErrors;
    
    public Error() {
    }

    /**
     * @param code
     * @param message
     */
    public Error(String code, String message) {
        this.code = code;
        this.message = message;
    }

    

    /**
     * @param code
     * @param message
     * @param validationErrors
     */
    public Error(String code, String message, Map<String, String> validationErrors) {
        this.code = code;
        this.message = message;
        this.validationErrors = validationErrors;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the validationErrors
     */
    public Map<String, String> getValidationErrors() {
        return validationErrors;
    }

    /**
     * @param validationErrors the validationErrors to set
     */
    public void setValidationErrors(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }
    
}
