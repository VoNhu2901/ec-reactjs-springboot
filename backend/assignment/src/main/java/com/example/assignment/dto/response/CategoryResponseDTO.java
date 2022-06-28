package com.example.assignment.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CategoryResponseDTO {
    private Long id;
    private String name;
}
