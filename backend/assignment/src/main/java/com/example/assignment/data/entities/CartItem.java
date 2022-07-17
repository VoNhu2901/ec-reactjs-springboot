package com.example.assignment.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cart_item")
@IdClass(CartItemId.class)
public class CartItem implements Serializable {

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


    public CartItem(int cartId, int proId, int quantity) {
        this.cartId = cartId;
        this.proId = proId;
        this.quantity = quantity;
    }


}
