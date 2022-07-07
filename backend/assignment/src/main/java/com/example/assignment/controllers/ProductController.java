package com.example.assignment.controllers;

import com.example.assignment.data.entities.Product;
import com.example.assignment.dto.request.ProductCreateDto;
import com.example.assignment.dto.response.ProductResponseDto;
import com.example.assignment.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<ProductResponseDto> getProductOnTrading() {
        return this.productService.getProductOnTrading();
    } 

    @GetMapping("/all")
    public List<ProductResponseDto> getAllProduct() {
        return this.productService.getAllProduct(); 
    } 

    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable("id") int id) {
        return this.productService.getProductById(id);
    }

    @GetMapping("/top")
    public List<Product> getProductByRate(){
        return this.productService.getProductByRate();
    }

    @GetMapping("/category/{cateId}")
    public List<Product> getProductByCategory(@PathVariable("cateId") int cate) {
        return this.productService.getProductByCategory(cate);
    }

    /**
     * Create new product
     * 
     * @param productData
     * @return
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto createNewProduct(@RequestBody ProductCreateDto productData) {
        return this.productService.createNewProduct(productData);
    }


    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDto updateStatusProduct(@PathVariable("id") int id) {
        return this.productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDto updateProduct(@PathVariable("id") int id,
            @RequestBody ProductCreateDto productCreateDto) {
        return this.productService.updateProduct(id, productCreateDto);
    }
}