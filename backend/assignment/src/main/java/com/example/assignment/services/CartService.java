package com.example.assignment.services;


import com.example.assignment.dto.request.CartItemCreateDto;
import com.example.assignment.dto.response.CartResponseDto;
import com.example.assignment.dto.response.SuccessResponse;
import org.springframework.http.ResponseEntity;

public interface CartService {

    public CartResponseDto getCartByAccount(int accId);


    public ResponseEntity<SuccessResponse> addProductToCart(CartItemCreateDto dto);

    public ResponseEntity<SuccessResponse> updateQuantityProduct(CartItemCreateDto dto);

    public ResponseEntity<SuccessResponse> deleteProductOutOfCart(int proId, int cartId);

}
