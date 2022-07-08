package com.example.assignment.services;

import com.example.assignment.dto.request.OrderCreateDto;
import com.example.assignment.dto.response.OrderResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    ResponseEntity<?> createNewOrder(OrderCreateDto dto);

    List<OrderResponseDto> getAllOrderByAccId(int id);

    List<OrderResponseDto> getAllOrder();

    ResponseEntity<?> updateStatusOrder(int orderId, String status);

}
