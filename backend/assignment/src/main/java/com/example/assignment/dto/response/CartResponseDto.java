package com.example.assignment.dto.response;

import java.util.List;

public class CartResponseDto {
    List<CartItemResponseDto> items;
    private int id;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the items
     */
    public List<CartItemResponseDto> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<CartItemResponseDto> items) {
        this.items = items;
    }

}
