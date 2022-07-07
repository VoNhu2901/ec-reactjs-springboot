package com.example.assignment.services;

import com.example.assignment.data.entities.Product;
import com.example.assignment.dto.request.ProductCreateDto;
import com.example.assignment.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {

    /**
     * get all product when status = true
     * @return list of product
     */
    public List<ProductResponseDto> getProductOnTrading();

    /**
     * get all product do not consider any conditions
     * @return list of product
     */
    public List<ProductResponseDto> getAllProduct();

    
    public ProductResponseDto getProductById(int id);

    public List<Product> getProductByRate();

    /**
     * Get all product with category
     * 
     * @param cateId: what client want to get
     * @return list of product have same cateId
     */
    public List<Product> getProductByCategory(int cateId);

    /**
     * Create new product
     * 
     * @param productCreateDto: date to create
     * @return new product
     */
    public ProductResponseDto createNewProduct(ProductCreateDto productCreateDto);

    /**
     * Delete product
     * 
     * @param proId id of product
     * @return product had been change status
     */
    public ProductResponseDto deleteProduct(int proId);

    /**
     * Update product with id
     * 
     * @param id               of product
     * @param productCreateDto data to update
     * @return Product had been updated
     */
    public ProductResponseDto updateProduct(int id, ProductCreateDto productCreateDto);
}
