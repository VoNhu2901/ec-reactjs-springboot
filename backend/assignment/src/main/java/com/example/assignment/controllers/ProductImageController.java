package com.example.assignment.controllers;

import com.example.assignment.services.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/image")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductImageController {

    @Autowired
    private ProductImageService productImageService;

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteImage(@PathVariable("id") int id) {
        return this.productImageService.deleteImage(id);
    }

}
