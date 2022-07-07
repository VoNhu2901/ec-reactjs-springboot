package com.example.assignment.dto.request;

public class OrderCreateDto {
    private int cartId;
    private int accId;

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
     * @return the accId
     */
    public int getAccId() {
        return accId;
    }

    /**
     * @param accId the accId to set
     */
    public void setAccId(int accId) {
        this.accId = accId;
    }

}
