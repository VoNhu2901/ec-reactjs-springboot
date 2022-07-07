package com.example.assignment.data.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product_rate")
public class ProductRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "acc_id")
    private int accId;

    @Column(name = "rate")
    private double rate;

    @Column(name = "comment")
    private String comment;

    @Column(name = "create_date", updatable = false)
    @CreationTimestamp
    private Date createDate;

    @Column(name = "updated_date")
    @UpdateTimestamp
    private Date updateDate;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "pro_id")
    private Product product;

    /**
     * @param id
     */
    public ProductRate(int id) {
        this.id = id;
    }

    
    /**
     * 
     */
    public ProductRate() {
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
     * @return the accId
     */
    public int getAccId() {
        return accId;
    }

    /**
     * @param accId the accId to set
     */
    public void setAccId(int accId) {
        this.accId = accId;
    }

    /**
     * @return the rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
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
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }


    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }


    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    
}
