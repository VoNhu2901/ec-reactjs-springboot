package com.example.assignment.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AccountResponseDto {
    private int accId;
    private String username;
    private String password;
    private String address;
    private String email;
    private String phone;
    private Date createDate;
    private Date updateDate;
    private boolean status;
    private String role;


}
