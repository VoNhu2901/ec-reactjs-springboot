package com.example.assignment.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryResponseIdAndNameDto {
    private int id;
    private String name;

    public CategoryResponseIdAndNameDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
