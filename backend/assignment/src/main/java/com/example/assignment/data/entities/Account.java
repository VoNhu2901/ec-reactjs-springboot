package com.example.assignment.data.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "account", uniqueConstraints = { @UniqueConstraint(columnNames = "username") })
public class Account {

    @Id
    @Column(name = "acc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "create_date", updatable = false)
    @CreationTimestamp
    private Date createDate;

    @Column(name = "update_date")
    @UpdateTimestamp
    private Date updateDate;

    @Column(name = "status")
    private boolean status;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Set<Cart> carts;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Set<Ordered> orders;

    public Account() {
        // default construction
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

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }


    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }


    /**
     * @param accId
     */
    public Account(int accId) {
        this.accId = accId;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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
     * @return the carts
     */
    public Set<Cart> getCarts() {
        return carts;
    }

    /**
     * @param carts the carts to set
     */
    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    /**
     * @return the orders
     */
    public Set<Ordered> getOrders() {
        return orders;
    }

    /**
     * @param orders the orders to set
     */
    public void setOrders(Set<Ordered> orders) {
        this.orders = orders;
    }

    
    
}
