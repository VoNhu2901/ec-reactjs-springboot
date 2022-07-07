package com.example.assignment.dto.response;

public class ImageResponseIdAndUrlDto {
    private int id;
    private String imgUrl;

    /**
     * 
     */
    public ImageResponseIdAndUrlDto() {
    }

    /**
     * @param id
     * @param imgUrl
     */
    public ImageResponseIdAndUrlDto(int id, String imgUrl) {
        this.id = id;
        this.imgUrl = imgUrl;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the imgUrl
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @param imgUrl the imgUrl to set
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
