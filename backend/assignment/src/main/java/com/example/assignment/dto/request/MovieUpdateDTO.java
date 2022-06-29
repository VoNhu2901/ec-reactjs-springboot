package com.example.assignment.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

import java.time.LocalDate;

@Data
public class MovieUpdateDTO {
    @NotBlank(message = "Title is required")
    private String title;
    private String description;
    private LocalDate releaseYear;
    private Integer price;
    private Integer length;
    private Integer rating;
    private String urlImage;
    private String urlTrailer;
    private Integer amount;
    private Integer status;
}
