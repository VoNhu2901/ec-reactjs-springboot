package com.example.assignment.services;

import com.example.assignment.dto.request.ProductRateCreateDto;
import com.example.assignment.dto.response.ProductRateResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductRateService {
    ResponseEntity<?> createNewRate(ProductRateCreateDto dto);

    List<ProductRateResponseDto> getRatesByProductId(int proId, boolean status);

    ResponseEntity<?> changeStatus(int rateId);

}
