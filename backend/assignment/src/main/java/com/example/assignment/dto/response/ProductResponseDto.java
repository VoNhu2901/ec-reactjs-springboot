package com.example.assignment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
    private int proId;
    private String name;
    private String description;
    private double price;
    private int amount;
    private Boolean status;
    private double rate;
    private Set<ImageResponseIdAndUrlDto> productImages;
    private CategoryResponseIdAndNameDto category;
    private Date updateDate;
    private Date createDate;

    public ProductResponseDto(String name, String description, double price, int amount, Boolean status) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.status = status;
    }

}
