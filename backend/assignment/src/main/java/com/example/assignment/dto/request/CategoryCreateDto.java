package com.example.assignment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryCreateDto {

    @NotBlank(message = "Category name is required")
    private String cateName;

    @NotBlank(message = "Category description is required")
    private String cateDescription;


}
