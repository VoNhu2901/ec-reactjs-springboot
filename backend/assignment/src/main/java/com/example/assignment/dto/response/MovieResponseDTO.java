package com.example.assignment.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovieResponseDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime releaseYear;
    private Integer price;
    private Integer length;
    private Integer rating;
    private String urlImage;
    private String urlTrailer;
    private Integer amount;
    private Integer status;
}
