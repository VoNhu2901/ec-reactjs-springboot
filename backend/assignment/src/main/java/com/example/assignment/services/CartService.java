package com.example.assignment.services;


import com.example.assignment.dto.request.CartItemCreateDto;
import com.example.assignment.dto.response.CartResponseDto;
import com.example.assignment.exceptions.handlers.MessageResponse;

public interface CartService {

    CartResponseDto getCartByAccount(int accId);

    MessageResponse addProductToCart(CartItemCreateDto dto);

    MessageResponse updateQuantityProduct(CartItemCreateDto dto);

    MessageResponse deleteProductOutOfCart(int proId, int cartId);

}
