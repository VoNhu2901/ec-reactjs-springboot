package com.example.assignment.services;

import com.example.assignment.dto.request.OrderCreateDto;
import com.example.assignment.dto.response.OrderResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    public ResponseEntity<?> createNewOrder(OrderCreateDto dto);

    public List<OrderResponseDto> getAllOrderByAccId(int id);

    public List<OrderResponseDto> getAllOrder();

    public ResponseEntity<?> updateStatusOrder(int orderId, String status);
    
}
