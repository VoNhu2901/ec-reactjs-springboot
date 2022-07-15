package com.example.assignment.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreateDto {
    private String name;
    private String description;
    private int amount;
    private double price;
    private int categoryId;
    private String[] images;


}
