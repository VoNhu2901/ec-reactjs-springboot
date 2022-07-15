package com.example.assignment.controllers;

import com.example.assignment.exceptions.handlers.MessageResponse;
import com.example.assignment.services.ProductImageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Product Image Resources")
@RestController
@RequestMapping("/api/v1/image")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductImageController {

    @Autowired
    private ProductImageService productImageService;

    @DeleteMapping("/{id}")
    public MessageResponse deleteImage(@PathVariable("id") int id) {
        return this.productImageService.deleteImage(id);
    }

}
