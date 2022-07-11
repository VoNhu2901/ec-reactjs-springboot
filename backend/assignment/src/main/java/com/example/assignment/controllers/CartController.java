package com.example.assignment.controllers;

import com.example.assignment.dto.request.CartItemCreateDto;
import com.example.assignment.dto.response.CartResponseDto;
import com.example.assignment.dto.response.SuccessResponse;
import com.example.assignment.services.CartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Cart Resources")
@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/api/v1/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{id}")
    public CartResponseDto getCartByAccount(@PathVariable int id) {
        return this.cartService.getCartByAccount(id);
    }

    @PostMapping()
    public ResponseEntity<SuccessResponse> addProductIntoCart(@RequestBody CartItemCreateDto dto) {
        return this.cartService.addProductToCart(dto);
    }

    @PutMapping()
    public ResponseEntity<SuccessResponse> updateQuantityProduct(@RequestBody CartItemCreateDto dto) {
        return this.cartService.updateQuantityProduct(dto);
    }

    @DeleteMapping()
    public ResponseEntity<SuccessResponse> deleteProductOutOfCart(int proId, int cartId) {
        return this.cartService.deleteProductOutOfCart(proId, cartId);
    }

}

