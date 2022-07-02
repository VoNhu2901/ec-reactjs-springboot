package com.example.assignment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountUpdateDTO {
     @NotBlank(message = "Firstname is required")
    private String firstName;
    private String lastName;
    private String password;
//    private String matchingPassword;
     @Email(message = "Email is required")
    private String email;
    private String avatar;
     @Pattern(regexp = "^\\d{10}$", message = "Phone number is required")
    private String phone;
    private String address;

    // @Min(18)
    // @Max(100)
    // private Integer age;
    //sau do qua Controller khai bao @Valid
}
