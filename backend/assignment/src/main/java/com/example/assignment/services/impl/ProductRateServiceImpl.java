package com.example.assignment.services.impl;

import com.example.assignment.data.entities.Product;
import com.example.assignment.data.entities.ProductRate;
import com.example.assignment.data.repositories.ProductRateRepository;
import com.example.assignment.data.repositories.ProductRepository;
import com.example.assignment.dto.request.ProductRateCreateDto;
import com.example.assignment.dto.response.ProductRateResponseDto;
import com.example.assignment.exceptions.ResourceAlreadyExistsException;
import com.example.assignment.exceptions.ResourceNotFoundException;
import com.example.assignment.exceptions.handlers.MessageResponse;
import com.example.assignment.services.ProductRateService;
import com.example.assignment.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductRateServiceImpl implements ProductRateService {

    @Autowired
    private ProductRateRepository productRateRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MessageResponse createNewRate(ProductRateCreateDto dto) {
        Product product = productRepository.findById(dto.getProId()).orElseThrow(() -> new ResourceNotFoundException());
        Optional<ProductRate> productRate = productRateRepository.findByAccIdAndProduct(dto.getAccId(), product);
        if (productRate.isPresent()) {
            throw new ResourceAlreadyExistsException("You have commented on this product before.");
        }
        ProductRate newRate = new ProductRate();
        newRate.setAccId(dto.getAccId());
        newRate.setComment(dto.getComment());
        newRate.setProduct(product);
        newRate.setRate(dto.getRate());
        this.productRateRepository.save(newRate);
        return new MessageResponse(HttpStatus.CREATED, "Create successfully");
    }

    @Override
    public List<ProductRateResponseDto> getRatesByProductId(int proId, boolean status) {
        List<ProductRate> lProductRates;
        if (status) {
            lProductRates = this.productRateRepository.findByStatus(true);
        } else {
            lProductRates = this.productRateRepository.findAll();
        }

        if (lProductRates.isEmpty()) {
            throw new ResourceNotFoundException(Utils.NO_PRODUCT);
        }

        List<ProductRateResponseDto> result = new ArrayList<>();
        for (ProductRate product : lProductRates) {
            result.add(modelMapper.map(product, ProductRateResponseDto.class));
        }
        return result;
    }

    @Override
    public MessageResponse changeStatus(int rateId) {
        ProductRate productRateOptional = this.productRateRepository.findById(rateId)
                .orElseThrow(() -> new ResourceNotFoundException(Utils.PRODUCT_NOT_FOUND));

        boolean oldStatus = productRateOptional.isStatus();
        productRateOptional.setStatus(!oldStatus);
        this.productRateRepository.save(productRateOptional);

        return new MessageResponse(HttpStatus.OK,
                "Change status have Id: " + rateId + " to " + !oldStatus + " successfully");
    }

}
