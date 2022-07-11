package com.example.assignment.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ImageResponseIdAndUrlDto {
    private int id;
    private String imgUrl;


    public ImageResponseIdAndUrlDto(int id, String imgUrl) {
        this.id = id;
        this.imgUrl = imgUrl;
    }


}
