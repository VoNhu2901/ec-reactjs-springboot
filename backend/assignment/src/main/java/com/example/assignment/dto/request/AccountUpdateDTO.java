package com.example.assignment.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AccountUpdateDTO {
    @NotBlank(message = "Firstname is required")
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String avatar;
    private String phone;
    private String address;
}
