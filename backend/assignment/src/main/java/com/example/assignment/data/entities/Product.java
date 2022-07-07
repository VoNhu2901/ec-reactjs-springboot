package com.example.assignment.data.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private int proId;

    @Column(name = "product_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "amount")
    private int amount;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @OneToOne(mappedBy = "product")
    private CartItem cartItem;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ProductImage> productImages;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cate_id")
    private Category category;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    private Set<ProductRate> productRates;

    public Product() {
        //default constructor
    }
    
    /**
     * @param proId
     */
    public Product(int proId) {
        this.proId = proId;
    }

    /**
     * @return the proId
     */
    public int getProId() {
        return proId;
    }

    /**
     * @param proId the proId to set
     */
    public void setProId(int proId) {
        this.proId = proId;
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
     * @return the status
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Boolean status) {
        this.status = status;
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
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate() {
        this.createDate = new Date();
    }

    /**
     * @return the updateDate
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate the updateDate to set
     */
    public void setUpdateDate() {
        this.updateDate = new Date();
    }

    /**
     * @return the cartItem
     */
    public CartItem getCartItem() {
        return cartItem;
    }

    /**
     * @param cartItem the cartItem to set
     */
    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    /**
     * @return the productImages
     */
    public Set<ProductImage> getProductImages() {
        return productImages;
    }

    /**
     * @param productImages the productImages to set
     */
    public void setProductImages(Set<ProductImage> productImages) {
        this.productImages = productImages;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return the productRates
     */
    public Set<ProductRate> getProductRates() {
        return productRates;
    }

    /**
     * @param productRates the productRates to set
     */
    public void setProductRates(Set<ProductRate> productRates) {
        this.productRates = productRates;
    }

}
