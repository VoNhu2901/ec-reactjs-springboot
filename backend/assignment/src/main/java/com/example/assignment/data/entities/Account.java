package com.example.assignment.data.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Account")
@Data
@Table(name = "account")
public class Account {
        @OneToMany(mappedBy = "account", orphanRemoval = true, cascade = { CascadeType.ALL })
        private final List<Invoice> invoices = new ArrayList<>();
        @OneToMany(mappedBy = "account", cascade = { CascadeType.ALL })
        private final List<Rating> ratings = new ArrayList<>();
        @OneToMany(mappedBy = "account", cascade = { CascadeType.ALL })
        private final List<RoleItem> roleItems = new ArrayList<>();
        
        @Id
        // @GeneratedValue(strategy = GenerationType.AUTO)
        @SequenceGenerator(name = "account_squence", sequenceName = "account_squence", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_squence")
        
        @Column(name = "id", updatable = false)
        private Long id;
        
        @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
        private String firstName;
       
        @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
        private String lastName;
       
        @Column(name = "password", nullable = false, columnDefinition = "TEXT")
        private String password;
       
        @Column(name = "email", nullable = false, columnDefinition = "TEXT")
        private String email;
        
        @Column(name = "avatar", nullable = true, columnDefinition = "TEXT")
        private String avatar;
        
        @Column(name = "phone", nullable = true, columnDefinition = "TEXT")
        private String phone;
        
        @Column(name = "address", nullable = true, columnDefinition = "TEXT")
        private String address;
       
        @Column(name = "create_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
        private LocalDateTime createAt;
       
        @Column(name = "update_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
        private LocalDateTime updateAt;
}
