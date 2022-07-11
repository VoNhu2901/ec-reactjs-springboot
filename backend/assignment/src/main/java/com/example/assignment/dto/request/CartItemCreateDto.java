package com.example.assignment.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartItemCreateDto {
    private int proId;
    private int cartId;
    private int quantity;


}
