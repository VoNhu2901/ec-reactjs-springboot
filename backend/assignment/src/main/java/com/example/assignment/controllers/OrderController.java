package com.example.assignment.controllers;

import com.example.assignment.dto.request.OrderCreateDto;
import com.example.assignment.dto.response.OrderResponseDto;
import com.example.assignment.exceptions.handlers.MessageResponse;
import com.example.assignment.services.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Order Resources")
@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/{accId}")
    public List<OrderResponseDto> getAllOrderByAccId(@PathVariable int accId) {

        return this.orderService.getAllOrderByAccId(accId);
    }


    @GetMapping("/all")
    public List<OrderResponseDto> getAllOrder() {
        return this.orderService.getAllOrder();
    }


    @PostMapping()
    public MessageResponse createNewOrder(@Valid @RequestBody OrderCreateDto dto) {
        return this.orderService.createNewOrder(dto);
    }

    @PatchMapping("/{orderId}/{status}")
    public MessageResponse updateStatusOrder(@PathVariable int orderId, @PathVariable String status) {
        return this.orderService.updateStatusOrder(orderId, status);
    }
}
