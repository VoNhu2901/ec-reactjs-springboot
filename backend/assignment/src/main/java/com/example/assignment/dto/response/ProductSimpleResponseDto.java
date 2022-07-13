package com.example.assignment.dto.response;

import com.example.assignment.data.entities.Product;
import com.example.assignment.data.entities.ProductImage;
import com.example.assignment.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSimpleResponseDto {
    private int proId;
    private String name;
    private double price;
    private int amount;
    private double rate;
    private String thumbnail;


    public ProductSimpleResponseDto build(Product pro) {
        String thumb = "";
        if (!pro.getProductImages().isEmpty())
            for (ProductImage img : pro.getProductImages()) {
                thumb = img.getImgUrl();
                break;
            }

        return new ProductSimpleResponseDto(pro.getProId(), pro.getName(), pro.getPrice(), pro.getAmount(),
                Utils.rate(pro.getProductRates()), thumb);
    }


}