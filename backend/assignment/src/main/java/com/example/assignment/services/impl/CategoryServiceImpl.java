package com.example.assignment.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.data.entities.Category;
import com.example.assignment.data.repositories.CategoryRepository;
import com.example.assignment.dto.request.CategoryUpdateDTO;
import com.example.assignment.dto.response.CategoryResponseDTO;
import com.example.assignment.exceptions.ResourceFoundException;
import com.example.assignment.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) {
        return modelMapper.map(
                this.categoryRepository.findById(id).orElseThrow(() -> new ResourceFoundException("Category Not Found")),
                CategoryResponseDTO.class);
    }

    @Override
    public CategoryResponseDTO createCategory(CategoryUpdateDTO dto) {
        Category category = modelMapper.map(dto, Category.class);
        Category savecategory = categoryRepository.save(category);
        return modelMapper.map(savecategory, CategoryResponseDTO.class);
    }

    @Override
    public CategoryResponseDTO updateCategory(Long id, CategoryUpdateDTO dto) {
        Category category = modelMapper.map(dto, Category.class);
        category.setId(id);
        Category savecategory = categoryRepository.save(category);
        return modelMapper.map(savecategory, CategoryResponseDTO.class);
    }

    @Override
    public CategoryResponseDTO deleteCategory(Long id) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceFoundException("Category Not Found"));

        this.categoryRepository.delete(category);
        return modelMapper.map(category, CategoryResponseDTO.class);
    }

    @Override
    public CategoryResponseDTO getCategoryByName(String name) {
        return modelMapper.map(
                this.categoryRepository.findByName(name),
                CategoryResponseDTO.class);
    }
}
