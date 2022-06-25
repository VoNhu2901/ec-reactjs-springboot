package com.example.assignment.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CategoryUpdateDTO {
    @NotBlank(message = "Category is required")

    private String name;

}
