package com.example.assignment.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CartResponseDto {
    private int id;
    Set<CartItemResponseDto> cartItems;

}
