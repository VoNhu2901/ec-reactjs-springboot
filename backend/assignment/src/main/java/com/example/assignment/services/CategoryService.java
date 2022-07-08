package com.example.assignment.services;


import com.example.assignment.data.entities.Category;
import com.example.assignment.dto.request.CategoryCreateDto;
import com.example.assignment.dto.response.CategoryResponseDto;

import java.util.List;


public interface CategoryService {
    List<CategoryResponseDto> getAllCategory();

    CategoryResponseDto createNewCategory(CategoryCreateDto dto);

    CategoryResponseDto updateCategory(int id, CategoryCreateDto dto);

    CategoryResponseDto updateCategoryStatus(int id);

    Category getCategoryById(int id);
}
