package com.example.assignment.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
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


}
