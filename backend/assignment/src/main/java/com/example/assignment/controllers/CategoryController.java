package com.example.assignment.controllers;

import com.example.assignment.dto.request.CategoryCreateDto;
import com.example.assignment.dto.response.CategoryResponseDto;
import com.example.assignment.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService service) {
        this.categoryService = service;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponseDto createNewCategory(@Valid @RequestBody CategoryCreateDto dto) {
        return this.categoryService.createNewCategory(dto);
    }

    @PutMapping("/{id}")
    public CategoryResponseDto updateCategory(@Valid @RequestBody CategoryCreateDto dto, @PathVariable("id") int id) {
        return this.categoryService.updateCategory(id, dto);
    }

    @PatchMapping("/{id}")
    public CategoryResponseDto updateStatusCategory(@PathVariable("id") int id) {
        return this.categoryService.updateCategoryStatus(id);
    }

    @GetMapping()
    public List<CategoryResponseDto> getAllCategory() {
        return this.categoryService.getAllCategory();
    }

}
