package com.example.assignment.controllers;

import com.example.assignment.dto.request.ProductRateCreateDto;
import com.example.assignment.dto.response.ProductRateResponseDto;
import com.example.assignment.services.ProductRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rate")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductRateController {

    @Autowired
    private ProductRateService productRateService;

    @PostMapping()
    public ResponseEntity<?> createNewRate(@Valid @RequestBody ProductRateCreateDto dto) {
        return this.productRateService.createNewRate(dto);
    }

    @GetMapping("/{id}")
    public List<ProductRateResponseDto> getProductRates(@PathVariable int id) {
        return this.productRateService.getRatesByProductId(id, true);
    }

    @GetMapping("/all/{id}")
    public List<ProductRateResponseDto> getAllProductRates(@PathVariable int id) {
        return this.productRateService.getRatesByProductId(id, false);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> changeStatusProductRate(@PathVariable int id) {
        return this.productRateService.changeStatus(id);
    }
}
