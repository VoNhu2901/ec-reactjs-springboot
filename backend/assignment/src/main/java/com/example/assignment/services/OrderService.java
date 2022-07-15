package com.example.assignment.services;

import com.example.assignment.dto.request.OrderCreateDto;
import com.example.assignment.dto.response.OrderResponseDto;
import com.example.assignment.exceptions.handlers.MessageResponse;

import java.util.List;

public interface OrderService {
    public MessageResponse createNewOrder(OrderCreateDto dto);

    public List<OrderResponseDto> getAllOrderByAccId(int id);

    public List<OrderResponseDto> getAllOrder();

    public MessageResponse updateStatusOrder(int orderId, String status);
}
