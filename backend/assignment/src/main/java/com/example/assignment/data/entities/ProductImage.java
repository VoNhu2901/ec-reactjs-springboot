package com.example.assignment.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product_image")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "img_url")
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "pro_id")
    private Product product;


    public ProductImage(int id) {
        this.id = id;
    }


}
