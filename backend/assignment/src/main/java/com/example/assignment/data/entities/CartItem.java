package com.example.assignment.data.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart_item")
@IdClass(CartItemId.class)
public class CartItem implements Serializable{

    @Id
    @Column(name = "cart_id")
    private int cartId;

    @Id
    @Column(name = "pro_id")
    private int proId;

    @Column(name = "quantity")
    private int quantity;
    
    @ManyToOne
    @JoinColumn(name = "cart_id", insertable = false, updatable = false)
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id", insertable = false, updatable = false)
    private Product product;

    /**
     * 
     */
    public CartItem() {
    }

    /**
     * @param cartId
     * @param proId
     * @param quantity
     */
    public CartItem(int cartId, int proId, int quantity) {
        this.cartId = cartId;
        this.proId = proId;
        this.quantity = quantity;
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
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the cart
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * @param cart the cart to set
     */
    public void setCart(Cart cart) {
        this.cart = cart;
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

    


}
