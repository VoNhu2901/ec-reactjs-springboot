package com.example.assignment.services.impl;

import com.example.assignment.data.repositories.ProductImageRepository;
import com.example.assignment.exceptions.handlers.MessageResponse;
import com.example.assignment.services.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProductImageServiceImpl implements ProductImageService {
    @Autowired
    private ProductImageRepository productImageRepository;


    @Override
    public MessageResponse deleteImage(int id) {
        this.productImageRepository.deleteById(id);
        return new MessageResponse(HttpStatus.ACCEPTED, "Delete.image.successfully");

    }

}
