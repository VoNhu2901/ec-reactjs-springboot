package com.example.assignment.services;


import com.example.assignment.dto.request.CartItemCreateDto;
import com.example.assignment.dto.response.CartResponseDto;
import com.example.assignment.dto.response.SuccessResponse;
import org.springframework.http.ResponseEntity;

public interface CartService {
    /**
     * get cart is active for user have accId
     *
     * @param accId id of user
     * @return cart and product into that
     */
    CartResponseDto getCartByAccount(int accId);

    /**
     * Add new product to cart
     *
     * @param dto include 3 param proId and cartId and quantity
     * @return success or error
     */
    ResponseEntity<SuccessResponse> addProductToCart(CartItemCreateDto dto);

    ResponseEntity<SuccessResponse> updateQuantityProduct(CartItemCreateDto dto);

    ResponseEntity<SuccessResponse> deleteProductOutOfCart(int proId, int cartId);

}
