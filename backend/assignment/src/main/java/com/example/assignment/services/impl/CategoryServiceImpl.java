package com.example.assignment.services.impl;

import com.example.assignment.data.entities.Category;
import com.example.assignment.data.repositories.CategoryRepository;
import com.example.assignment.dto.request.CategoryCreateDto;
import com.example.assignment.dto.response.CategoryResponseDto;
import com.example.assignment.exceptions.ResourceAlreadyExistsException;
import com.example.assignment.exceptions.ResourceNotFoundException;
import com.example.assignment.services.CategoryService;
import com.example.assignment.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ModelMapper modelMapper;


    @Override
    public CategoryResponseDto createNewCategory(CategoryCreateDto dto) {
        Optional<Category> categoryOptional = this.categoryRepository.findByName(dto.getCateName());
        if (categoryOptional.isPresent()) {
            throw new ResourceAlreadyExistsException("Category.is.already.exist");
        }

        Category category = modelMapper.map(dto, Category.class);
        category.setStatus(Utils.CATEGORY_ACTIVE);
        Category saveCategory = this.categoryRepository.save(category);
        return modelMapper.map(saveCategory, CategoryResponseDto.class);
    }

    @Override
    public List<CategoryResponseDto> getAllCategory() {
        List<Category> lCategories = this.categoryRepository.findAll();
        List<CategoryResponseDto> result = new ArrayList<>();
        for (Category cate : lCategories) {
            result.add(this.modelMapper.map(cate, CategoryResponseDto.class));
        }
        return result;
    }

    @Override
    public CategoryResponseDto updateCategory(int id, CategoryCreateDto dto) {
        Optional<Category> categoRyOptional = this.categoryRepository.findById(id);
        if (categoRyOptional.isEmpty()) {
            throw new ResourceNotFoundException("Category.not.exist");
        }

        Category category = categoRyOptional.get();
        modelMapper.map(dto, category);
        category = this.categoryRepository.save(category);
        return modelMapper.map(category, CategoryResponseDto.class);
    }

    @Override
    public CategoryResponseDto updateCategoryStatus(int id) {
        Optional<Category> categoryOptional = this.categoryRepository.findById(id);
        if (categoryOptional.isEmpty()) {
            throw new ResourceNotFoundException("Category.not.exist");
        }

        Category category = categoryOptional.get();
        if ("Active".equals(category.getStatus())) {
            category.setStatus(Utils.CATEGORY_DEACTIVATE);
        } else {
            category.setStatus(Utils.CATEGORY_ACTIVE);
        }
        category = this.categoryRepository.save(category);
        return modelMapper.map(category, CategoryResponseDto.class);
    }

    @Override
    public CategoryResponseDto getCategoryById(int id) {
        Category category = this.categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category.not.exist"));
        return modelMapper.map(category, CategoryResponseDto.class);
    }
}
