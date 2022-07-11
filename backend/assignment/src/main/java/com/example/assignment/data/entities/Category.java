package com.example.assignment.data.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cate_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
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

    

    public Category(int id) {
        this.id = id;
    }


    public void setCreateDate() {
        this.createDate = new Date();
    }


    public void setUpdateDate() {
        this.updateDate = new Date();
    }

    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Category(String name, String description){
        this.name = name;
        this.description = description;
    }

}
