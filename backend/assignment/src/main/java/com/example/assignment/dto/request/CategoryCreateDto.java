package com.example.assignment.dto.request;

import javax.validation.constraints.NotBlank;

public class CategoryCreateDto {
    
    @NotBlank(message = "Category name is required")
    private String cateName;

    @NotBlank(message = "Category description is required")
    private String cateDescription;

    /**
     * @return the cateName
     */
    public String getCateName() {
        return cateName;
    }

    /**
     * @param cateName the cateName to set
     */
    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    /**
     * @return the cateDescription
     */
    public String getCateDescription() {
        return cateDescription;
    }

    /**
     * @param cateDescription the cateDescription to set
     */
    public void setCateDescription(String cateDescription) {
        this.cateDescription = cateDescription;
    }

    
    
}
