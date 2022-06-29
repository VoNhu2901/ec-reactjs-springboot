package com.example.assignment.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.assignment.data.entities.Category;
import com.example.assignment.dto.request.CategoryUpdateDTO;
import com.example.assignment.dto.response.CategoryResponseDTO;

public interface CategoryService {

  List<Category> getAllCategories();

  CategoryResponseDTO getCategoryById(Long id);

  CategoryResponseDTO createCategory(CategoryUpdateDTO dto);

  CategoryResponseDTO updateCategory(Long id, CategoryUpdateDTO dto);

  CategoryResponseDTO deleteCategory(Long id);

  CategoryResponseDTO getCategoryByName(String name);


}
