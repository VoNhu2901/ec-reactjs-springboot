package com.example.assignment.data.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private int proId;

    @Column(name = "product_name")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "amount")
    private int amount;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date createDate;

    @Column(name = "update_date")
    @UpdateTimestamp
    private Date updateDate;

    @OneToOne(mappedBy = "product")
    private CartItem cartItem;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ProductImage> productImages;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cate_id")
    private Category category;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ProductRate> productRates;

}
