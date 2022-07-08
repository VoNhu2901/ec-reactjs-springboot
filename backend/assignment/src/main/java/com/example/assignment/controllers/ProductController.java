package com.example.assignment.controllers;

import com.example.assignment.data.entities.Product;
import com.example.assignment.dto.request.ProductCreateDto;
import com.example.assignment.dto.response.ProductResponseDto;
import com.example.assignment.services.ProductService;
import com.example.assignment.utils.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = Utils.GET_LIST + Utils.PRODUCT)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = Utils.GET_LIST + Utils.PRODUCT + Utils.SUCCESS),
            @ApiResponse(responseCode = "404", description = Utils.NOT_FOUND + Utils.PRODUCT)
    })
    public List<ProductResponseDto> getAllProduct() {
        return this.productService.getAllProduct();
    }

    @GetMapping("/{id}")
    @Operation(summary = Utils.GET_ONE + Utils.PRODUCT)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = Utils.GET_ONE + Utils.PRODUCT + Utils.SUCCESS),
            @ApiResponse(responseCode = "404", description = Utils.NOT_FOUND + Utils.PRODUCT)
    })
    public ProductResponseDto getProductById(@PathVariable("id") int id) {
        return this.productService.getProductById(id);
    }

    @GetMapping("/top")
    public List<Product> getProductByRate() {
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