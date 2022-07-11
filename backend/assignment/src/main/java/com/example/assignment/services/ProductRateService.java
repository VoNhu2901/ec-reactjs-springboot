package com.example.assignment.services;

import com.example.assignment.dto.request.ProductRateCreateDto;
import com.example.assignment.dto.response.ProductRateResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductRateService {
    public ResponseEntity<?> createNewRate(ProductRateCreateDto dto);

    public List<ProductRateResponseDto> getRatesByProductId(int proId, boolean status);

    public ResponseEntity<?> changeStatus(int rateId);

}
