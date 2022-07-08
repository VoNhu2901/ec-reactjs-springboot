package com.example.assignment.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cate_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date createDate;

    @Column(name = "update_date")
    @CreationTimestamp
    private Date updateDate;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Set<Product> product;


    public Date getCreateDate() {
        return createDate;
    }


    public void setCreateDate() {
        this.createDate = new Date();
    }


    public Date getUpdateDate() {
        return updateDate;
    }


    public void setUpdateDate() {
        this.updateDate = new Date();
    }


}
