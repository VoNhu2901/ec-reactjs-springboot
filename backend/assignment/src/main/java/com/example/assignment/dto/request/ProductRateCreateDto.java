package com.example.assignment.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductRateCreateDto {
    private int accId;
    private int proId;
    private double rate;
    private String comment;


}
