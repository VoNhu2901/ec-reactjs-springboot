package com.example.assignment.services;

import com.example.assignment.dto.request.OrderCreateDto;
import com.example.assignment.dto.response.OrderResponseDto;
import com.example.assignment.exceptions.handlers.MessageResponse;

import java.util.List;

public interface OrderService {
    MessageResponse createNewOrder(OrderCreateDto dto);

    List<OrderResponseDto> getAllOrderByAccId(int id);

    List<OrderResponseDto> getAllOrder();

    MessageResponse updateStatusOrder(int orderId, String status);
}
