package com.example.assignment.data.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class CartItemId implements Serializable {
    private int cartId;
    private int proId;


    public CartItemId(int cartId, int proId) {
        this.cartId = cartId;
        this.proId = proId;
    }


}
