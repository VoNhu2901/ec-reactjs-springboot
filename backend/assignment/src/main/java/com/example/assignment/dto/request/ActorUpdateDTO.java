package com.example.assignment.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class ActorUpdateDTO {
    @NotBlank(message = "Firstname is required")
    private String firstName;
    private String lastName;
    private String avatar;

//    @Min(value = 1, message = "Price should be a positive number")
//    private Double price;
}
