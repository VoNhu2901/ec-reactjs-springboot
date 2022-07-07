package com.example.assignment.data.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int id;

    @Column(name = "active")
    private boolean active;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "create_date")
    private Date createDate;
    
    @ManyToOne
    @JoinColumn(name = "acc_id")
    private Account account;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
    private Set<CartItem> cartItems;

    public Cart() {
        //default con
    }
    
    /**
     * @param id
     */
    public Cart(int id) {
        this.id = id;
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

    /**
     * @return the cartItems
     */
    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    /**
     * @param cartItems the cartItems to set
     */
    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }
    
}
