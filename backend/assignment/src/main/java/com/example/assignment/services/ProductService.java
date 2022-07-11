package com.example.assignment.services;

import com.example.assignment.data.entities.Product;
import com.example.assignment.dto.request.ProductCreateDto;
import com.example.assignment.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {


    public List<ProductResponseDto> getProductOnTrading();


    public List<ProductResponseDto> getAllProduct();

    
    public ProductResponseDto getProductById(int id);


    public List<Product> getProductByCategory(int cateId);


    public ProductResponseDto createNewProduct(ProductCreateDto productCreateDto);


    public ProductResponseDto deleteProduct(int proId);


    public ProductResponseDto updateProduct(int id, ProductCreateDto productCreateDto);

}
