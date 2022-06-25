package com.example.assignment.data.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Account")
@Data
@Table(name = "account")
public class Account {
    @OneToMany(mappedBy = "account", orphanRemoval = true, cascade = {CascadeType.PERSIST,
            CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private final List<Invoice> invoices = new ArrayList<>();
    @OneToMany(mappedBy = "account", cascade = {CascadeType.PERSIST,
            CascadeType.REMOVE})
    private final List<Rating> ratings = new ArrayList<>();
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
    @Column(name = "create_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime createAt;
    @Column(name = "update_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime updateAt;
}
