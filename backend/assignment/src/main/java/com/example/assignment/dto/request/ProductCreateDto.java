package com.example.assignment.dto.request;

public class ProductCreateDto {
    private String name;
    private String description;
    private int amount;
    private double price;
    private int categoryId;
    private String[] images;

    /**
     * 
     */
    public ProductCreateDto() {
    }

    /**
     * @param name
     * @param description
     * @param amount
     * @param price
     * @param categoryId
     * @param images
     */
    public ProductCreateDto(String name, String description, int amount, double price, int categoryId,
            String[] images) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.price = price;
        this.categoryId = categoryId;
        this.images = images;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the images
     */
    public String[] getImages() {
        return images;
    }

    /**
     * @param images the images to set
     */
    public void setImages(String[] images) {
        this.images = images;
    }

}
