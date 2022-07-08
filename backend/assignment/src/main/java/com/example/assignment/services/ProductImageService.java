package com.example.assignment.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface ProductImageService {
    ResponseEntity<HttpStatus> deleteImage(int id);
}
