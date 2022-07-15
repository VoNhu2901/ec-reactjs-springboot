package com.example.assignment.services;


import com.example.assignment.dto.request.CartItemCreateDto;
import com.example.assignment.dto.response.CartResponseDto;
import com.example.assignment.exceptions.handlers.MessageResponse;

public interface CartService {

    public CartResponseDto getCartByAccount(int accId);

    public MessageResponse addProductToCart(CartItemCreateDto dto);

    public MessageResponse updateQuantityProduct(CartItemCreateDto dto);

    public MessageResponse deleteProductOutOfCart(int proId, int cartId);

}
