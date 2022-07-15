package com.example.assignment.services.impl;

import com.example.assignment.data.entities.Account;
import com.example.assignment.data.entities.Cart;
import com.example.assignment.data.entities.CartItem;
import com.example.assignment.data.repositories.AccountRepository;
import com.example.assignment.data.repositories.CartItemRepository;
import com.example.assignment.data.repositories.CartRepository;
import com.example.assignment.dto.request.CartItemCreateDto;
import com.example.assignment.dto.response.CartItemResponseDto;
import com.example.assignment.dto.response.CartResponseDto;
import com.example.assignment.exceptions.ResourceNotFoundException;
import com.example.assignment.exceptions.handlers.MessageResponse;
import com.example.assignment.services.CartService;
import com.example.assignment.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CartResponseDto getCartByAccount(int accId) {
        Account acc = this.accountRepository.findById(accId)
                .orElseThrow(() -> new ResourceNotFoundException(Utils.NO_ACCOUNT));

        Cart cart = this.cartRepository.findByAccountAndActive(acc, true);

        if (cart == null) {
            Cart newCart = new Cart();
            newCart.setAccount(acc);
            newCart.setActive(true);
            return modelMapper.map(this.cartRepository.save(newCart), CartResponseDto.class);

        }

        CartResponseDto res = modelMapper.map(cart, CartResponseDto.class);

        Set<CartItemResponseDto> cartItems = new HashSet<>();

        for (CartItem ele : cart.getCartItems()) {
            CartItemResponseDto dto = modelMapper.map(ele, CartItemResponseDto.class);
            dto.setName(ele.getProduct().getName());
            dto.setPrice(ele.getProduct().getPrice());
            cartItems.add(dto);
        }
        res.setCartItems(cartItems);
        return res;
    }

    @Override
    public MessageResponse addProductToCart(CartItemCreateDto dto) {
        // check cart is exist
        if (!this.cartRepository.existsById(dto.getCartId())) {
            throw new ResourceNotFoundException(Utils.NO_CART);
        }

        // save
        this.cartItemRepository.save(modelMapper.map(dto, CartItem.class));

        return new MessageResponse(HttpStatus.CREATED, "Added product into cart successfully");
    }

    @Override
    public MessageResponse updateQuantityProduct(CartItemCreateDto dto) {
        CartItem cartItem = this.cartItemRepository.findByCartIdAndProId(dto.getCartId(), dto.getProId());
        if (cartItem == null) {
            throw new ResourceNotFoundException(Utils.PRODUCT_NOT_FOUND);
        }

        cartItem.setQuantity(dto.getQuantity());

        this.cartItemRepository.save(cartItem);
        return new MessageResponse(HttpStatus.OK, "Changed Quantity");
    }

    @Override
    public MessageResponse deleteProductOutOfCart(int proId, int cartId) {
        CartItem cartItem = this.cartItemRepository.findByCartIdAndProId(cartId, proId);
        if (cartItem == null) {
            throw new ResourceNotFoundException(Utils.PRODUCT_NOT_FOUND);
        }

        this.cartItemRepository.delete(cartItem);

        return new MessageResponse(HttpStatus.OK, "Deleted product out of cart");
    }

}
