package com.example.assignment.controllers;

import java.util.List;

import com.example.assignment.data.entities.Category;
import com.example.assignment.dto.request.CategoryUpdateDTO;
import com.example.assignment.dto.response.CategoryResponseDTO;
import com.example.assignment.services.CategoryService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
  private final CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping
  List<Category> getCategories() {
    return this.categoryService.getAllCategories();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  CategoryResponseDTO getCategoryById(@PathVariable("id") Long id) {
    return this.categoryService.getCategoryById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  CategoryResponseDTO createCategory(@RequestBody CategoryUpdateDTO dto) {
    return this.categoryService.createCategory(dto);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  CategoryResponseDTO updateCategory(@PathVariable("id") Long id, @RequestBody CategoryUpdateDTO dto) {
    return this.categoryService.updateCategory(id, dto);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  CategoryResponseDTO deleteCategory(@PathVariable("id") Long id) {
    return this.categoryService.deleteCategory(id);
  }

  @GetMapping("name/{name}")
  @ResponseStatus(HttpStatus.OK)
  CategoryResponseDTO getCategoryByName(@PathVariable("name") String name) {
    return this.categoryService.getCategoryByName(name);
  }

  // @ExceptionHandler(CategoryNotFoundException.class)
  // @ResponseStatus(HttpStatus.NOT_FOUND)
  // String handleCategoryNotFound(CategoryNotFoundException e) {
  //   return e.getMessage();
  // }

}
