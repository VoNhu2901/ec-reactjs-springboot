package com.example.assignment.services.impl;

import com.example.assignment.data.repositories.ProductImageRepository;
import com.example.assignment.services.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    private final ProductImageRepository productImageRepository;

    @Autowired
    public ProductImageServiceImpl(ProductImageRepository repository) {
        this.productImageRepository = repository;
    }

    @Override
    public ResponseEntity<HttpStatus> deleteImage(int id) {
        this.productImageRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
