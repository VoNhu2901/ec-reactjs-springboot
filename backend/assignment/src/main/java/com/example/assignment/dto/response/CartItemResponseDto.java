package com.example.assignment.dto.response;


import com.example.assignment.data.entities.Product;

public class CartItemResponseDto {
    private int proId;
    private String name;
    private double price;
    private int quantity;

    

    /**
     * 
     */
    public CartItemResponseDto() {
    }

    public CartItemResponseDto(int id, String name, double price, int quantity) {
        this.proId = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public CartItemResponseDto build(Product pro, int quantity) {
        return new CartItemResponseDto(pro.getProId(), pro.getName(), pro.getPrice(), quantity);
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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
