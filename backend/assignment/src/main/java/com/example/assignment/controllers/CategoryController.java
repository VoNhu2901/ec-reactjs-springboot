package com.example.assignment.controllers;

import com.example.assignment.dto.request.CategoryCreateDto;
import com.example.assignment.dto.response.CategoryResponseDto;
import com.example.assignment.services.CategoryService;
import com.example.assignment.utils.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService service) {
        this.categoryService = service;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = Utils.CREATE_NEW + Utils.CATEGORY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = Utils.CREATE_NEW + Utils.CATEGORY + Utils.SUCCESS),
            @ApiResponse(responseCode = "404", description = Utils.NOT_FOUND + Utils.CATEGORY)
    })
    public CategoryResponseDto createNewCategory(@Valid @RequestBody CategoryCreateDto dto) {
        return this.categoryService.createNewCategory(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = Utils.PUT + Utils.CATEGORY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = Utils.PUT + Utils.CATEGORY + Utils.SUCCESS),
            @ApiResponse(responseCode = "404", description = Utils.NOT_FOUND + Utils.CATEGORY)
    })
    public CategoryResponseDto updateCategory(@Valid @RequestBody CategoryCreateDto dto, @PathVariable("id") int id) {
        return this.categoryService.updateCategory(id, dto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = Utils.PATCH + Utils.CATEGORY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = Utils.PATCH + Utils.CATEGORY + Utils.SUCCESS),
            @ApiResponse(responseCode = "404", description = Utils.NOT_FOUND + Utils.CATEGORY)
    })
    public CategoryResponseDto updateStatusCategory(@PathVariable("id") int id) {
        return this.categoryService.updateCategoryStatus(id);
    }

    @GetMapping()
    @Operation(summary = Utils.GET_LIST + Utils.CATEGORY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = Utils.GET_LIST + Utils.CATEGORY + Utils.SUCCESS),
            @ApiResponse(responseCode = "404", description = Utils.NOT_FOUND + Utils.CATEGORY)
    })
    public List<CategoryResponseDto> getAllCategory() {
        return this.categoryService.getAllCategory();
    }

}
