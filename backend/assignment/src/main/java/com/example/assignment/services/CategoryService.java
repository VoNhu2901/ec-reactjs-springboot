package com.example.assignment.services;


import com.example.assignment.data.entities.Category;
import com.example.assignment.dto.request.CategoryCreateDto;
import com.example.assignment.dto.response.CategoryResponseDto;

import java.util.List;


public interface CategoryService {
    public List<CategoryResponseDto> getAllCategory();
    public CategoryResponseDto createNewCategory(CategoryCreateDto dto);
    public CategoryResponseDto updateCategory(int id, CategoryCreateDto dto);
    public CategoryResponseDto updateCategoryStatus(int id);
    public Category getCategoryById(int id);
}
