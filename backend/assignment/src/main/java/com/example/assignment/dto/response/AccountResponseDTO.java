package com.example.assignment.dto.response;

import lombok.Data;

@Data
public class AccountResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String avatar;
    private String phone;
    private String address;
    private Boolean enabled;

}
