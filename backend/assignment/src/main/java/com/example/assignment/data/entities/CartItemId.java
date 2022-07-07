package com.example.assignment.data.entities;

import java.io.Serializable;

public class CartItemId implements Serializable {
    private int cartId;
    private int proId;

    /**
     * 
     */
    public CartItemId() {
    }

    /**
     * @param cartId
     * @param proId
     */
    public CartItemId(int cartId, int proId) {
        this.cartId = cartId;
        this.proId = proId;
    }

    /**
     * @return the cartId
     */
    public int getCartId() {
        return cartId;
    }

    /**
     * @param cartId the cartId to set
     */
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    /**
     * @return the proId
     */
    public int getProId() {
        return proId;
    }

    /**
     * @param proId the proId to set
     */
    public void setProId(int proId) {
        this.proId = proId;
    }
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cartId;
        result = prime * result + proId;
        return result;
    }
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */

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
