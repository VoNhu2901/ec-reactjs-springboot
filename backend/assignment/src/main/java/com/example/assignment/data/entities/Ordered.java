package com.example.assignment.data.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Ordered")
public class Ordered {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @Column(name = "cart_id")
    private int cartId;

    @Column(name = "status")
    private String status;

    @Column(name = "create_date", updatable = false)
    @CreationTimestamp
    private Date createDate;

    @Column(name = "update_date")
    @UpdateTimestamp
    private Date updateDate;

    @ManyToOne
    @JoinColumn(name = "acc_id")
    private Account account;

    public Ordered() {
        // default con
    }

    /**
     * @param orderId
     */
    public Ordered(int orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the cartId
     */
    public int getCartId() {
        return cartId;
    }

    /**
     * @param cartId the cartId to set
     */
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
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
     * @return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    
}
