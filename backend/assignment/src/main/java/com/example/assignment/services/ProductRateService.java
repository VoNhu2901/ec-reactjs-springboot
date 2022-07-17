package com.example.assignment.services;

import com.example.assignment.dto.request.ProductRateCreateDto;
import com.example.assignment.dto.response.ProductRateResponseDto;
import com.example.assignment.exceptions.handlers.MessageResponse;

import java.util.List;

public interface ProductRateService {
    MessageResponse createNewRate(ProductRateCreateDto dto);

    List<ProductRateResponseDto> getRatesByProductId(int proId, boolean status);

    MessageResponse changeStatus(int rateId);

}
