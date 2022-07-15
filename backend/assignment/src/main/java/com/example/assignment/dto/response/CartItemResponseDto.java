package com.example.assignment.dto.response;

import com.example.assignment.data.entities.Product;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemResponseDto {
    private int proId;
    private String name;
    private double price;
    private int quantity;


    public CartItemResponseDto build(Product pro, int quantity) {
        return new CartItemResponseDto(pro.getProId(), pro.getName(), pro.getPrice(), quantity);
    }


}
