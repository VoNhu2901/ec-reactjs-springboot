package com.example.assignment.services.impl;

import com.example.assignment.data.entities.Account;
import com.example.assignment.data.entities.Cart;
import com.example.assignment.data.entities.CartItem;
import com.example.assignment.data.entities.Ordered;
import com.example.assignment.data.repositories.AccountRepository;
import com.example.assignment.data.repositories.CartRepository;
import com.example.assignment.data.repositories.OrderRepository;
import com.example.assignment.data.repositories.ProductRepository;
import com.example.assignment.dto.request.OrderCreateDto;
import com.example.assignment.dto.response.CartItemResponseDto;
import com.example.assignment.dto.response.OrderResponseDto;
import com.example.assignment.dto.response.SuccessResponse;
import com.example.assignment.exceptions.ResourceNotFoundException;
import com.example.assignment.services.OrderService;
import com.example.assignment.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private ModelMapper modelMapper;
    private AccountRepository accountRepository;
    private CartRepository cartRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, ModelMapper mapper,
            AccountRepository accountRepository, CartRepository cartRepository) {
        this.modelMapper = mapper;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.accountRepository = accountRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public ResponseEntity<?> createNewOrder(OrderCreateDto dto) {
        // check valid account is exist?
        Account acc = this.accountRepository.findById(dto.getAccId())
                .orElseThrow(() -> new ResourceNotFoundException(Utils.NO_ACCOUNT));

        // Check cart is exist and set status to DONE
        Cart cart = this.cartRepository.findById(dto.getCartId())
                .orElseThrow(() -> new ResourceNotFoundException(Utils.NO_CART));
        cart.setActive(false);
        this.cartRepository.save(cart);

        // create new ordered
        Ordered order = new Ordered();
        order.setCartId(dto.getCartId());
        order.setAccount(acc);
        order.setStatus("Waiting For Confirm ");

        this.orderRepository.save(order);
        return ResponseEntity.ok(new SuccessResponse(HttpStatus.CREATED, Utils.CREATE_ORDER));
    }

    private List<OrderResponseDto> getListOrder(List<Ordered> listOrder) {

        List<OrderResponseDto> result = new ArrayList<>();
        for (Ordered ordered : listOrder) {
            OrderResponseDto res = modelMapper.map(ordered, OrderResponseDto.class);

            // get all product in cart
            Cart cart = this.cartRepository.findById(ordered.getCartId())
                    .orElseThrow(() -> new ResourceNotFoundException(Utils.NO_CART));
            List<CartItemResponseDto> listProduct = new ArrayList<>();
            for (CartItem item : cart.getCartItems()) {
                CartItemResponseDto proItem = new CartItemResponseDto();
                listProduct.add(proItem.build(item.getProduct(), item.getQuantity()));
            }

            result.add(res);
        }

        return result;
    }

    @Override
    public List<OrderResponseDto> getAllOrderByAccId(int id) {
        Account acc = this.accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Utils.NO_PRODUCT));

        List<Ordered> lOrdered = this.orderRepository.findByAccount(acc);

        if (lOrdered.isEmpty()) {
            throw new ResourceNotFoundException(Utils.NO_ORDER);
        }

        return getListOrder(lOrdered);
    }

    @Override
    public List<OrderResponseDto> getAllOrder() {
        List<Ordered> listOrder = this.orderRepository.findAll();
        if (listOrder.isEmpty()) {
            throw new ResourceNotFoundException(Utils.NO_ORDER);
        }
        return getListOrder(listOrder);
    }

    @Override
    public ResponseEntity<?> updateStatusOrder(int orderId, String status) {
        Ordered ordered = this.orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException(Utils.NO_ORDER));

        ordered.setStatus(status);
        this.orderRepository.save(ordered);

        return ResponseEntity
                .ok(new SuccessResponse(HttpStatus.OK, "Update status of order have id: " + orderId + " successfully"));
    }

}
