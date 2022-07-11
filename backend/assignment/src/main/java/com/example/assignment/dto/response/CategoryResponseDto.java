package com.example.assignment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseDto {

    private int id;
    private String name;
    private String description;
    private String status;
    private Date updateDate;
    private Date createDate;

    public CategoryResponseDto(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
