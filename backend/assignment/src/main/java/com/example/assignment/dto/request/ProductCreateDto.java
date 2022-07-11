package com.example.assignment.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductCreateDto {
    private String name;
    private String description;
    private int amount;
    private double price;
    private int categoryId;
    private String[] images;


    public ProductCreateDto(String name, String description, int amount, double price, int categoryId,
            String[] images) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.price = price;
        this.categoryId = categoryId;
        this.images = images;
    }


}
