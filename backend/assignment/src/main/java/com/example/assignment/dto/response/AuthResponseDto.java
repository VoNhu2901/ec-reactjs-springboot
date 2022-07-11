package com.example.assignment.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthResponseDto {
    private int accId;
    private String username;
    private String role;
    private String accessToken;


    public AuthResponseDto(int accId, String username, String role, String accessToken) {
        this.accId = accId;
        this.username = username;
        this.role = role;
        this.accessToken = accessToken;
    }


}
