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
@Table(name = "account", uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
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

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private Set<Cart> carts;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private Set<Ordered> orders;


    public Account(int accId) {
        this.accId = accId;
    }


}
