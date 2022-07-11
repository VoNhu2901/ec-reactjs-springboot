package com.example.assignment.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CartItemId implements Serializable {
    private int cartId;
    private int proId;


    public CartItemId(int cartId, int proId) {
        this.cartId = cartId;
        this.proId = proId;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cartId;
        result = prime * result + proId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CartItemId other = (CartItemId) obj;
        if (cartId != other.cartId)
            return false;
        if (proId != other.proId)
            return false;
        return true;
    }

}
