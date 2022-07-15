package com.example.assignment.services;

import com.example.assignment.dto.request.ProductRateCreateDto;
import com.example.assignment.dto.response.ProductRateResponseDto;
import com.example.assignment.exceptions.handlers.MessageResponse;

import java.util.List;

public interface ProductRateService {
    public MessageResponse createNewRate(ProductRateCreateDto dto);

    public List<ProductRateResponseDto> getRatesByProductId(int proId, boolean status);

    public MessageResponse changeStatus(int rateId);

}
