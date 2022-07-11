package com.example.assignment.dto.response;

import com.example.assignment.data.entities.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartItemResponseDto {
    private int proId;
    private String name;
    private double price;
    private int quantity;


    public CartItemResponseDto(int id, String name, double price, int quantity) {
        this.proId = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public CartItemResponseDto build(Product pro, int quantity) {
        return new CartItemResponseDto(pro.getProId(), pro.getName(), pro.getPrice(), quantity);
    }


}
