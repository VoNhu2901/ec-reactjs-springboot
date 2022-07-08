package com.example.assignment.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
