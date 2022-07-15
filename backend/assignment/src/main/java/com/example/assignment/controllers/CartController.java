package com.example.assignment.controllers;

import com.example.assignment.dto.request.CartItemCreateDto;
import com.example.assignment.dto.response.CartResponseDto;
import com.example.assignment.exceptions.handlers.MessageResponse;
import com.example.assignment.services.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Cart Resources")
@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/api/v1/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{id}")
    @Operation(summary = "Create.card.by.account.id")
    public CartResponseDto getCartByAccount(@PathVariable int id) {
        return this.cartService.getCartByAccount(id);
    }

    @PostMapping()
    public MessageResponse addProductIntoCart(@RequestBody CartItemCreateDto dto) {
        return this.cartService.addProductToCart(dto);
    }

    @PutMapping()
    public MessageResponse updateQuantityProduct(@RequestBody CartItemCreateDto dto) {
        return this.cartService.updateQuantityProduct(dto);
    }

    @DeleteMapping()
    public MessageResponse deleteProductOutOfCart(int proId, int cartId) {
        return this.cartService.deleteProductOutOfCart(proId, cartId);
    }

}

