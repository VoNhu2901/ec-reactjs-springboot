package com.example.assignment.services;

import com.example.assignment.dto.request.ProductCreateDto;
import com.example.assignment.dto.response.ProductResponseDto;
import com.example.assignment.dto.response.ProductSimpleResponseDto;

import java.util.List;

public interface ProductService {


    List<ProductSimpleResponseDto> getProductOnTrading();


    List<ProductResponseDto> getAllProduct();


    ProductResponseDto getProductById(int id);


    List<ProductSimpleResponseDto> getProductByCategory(int cateId);

    ProductResponseDto createNewProduct(ProductCreateDto productCreateDto);


    ProductResponseDto deleteProduct(int proId);

    ProductResponseDto updateProduct(int id, ProductCreateDto productCreateDto);
}
