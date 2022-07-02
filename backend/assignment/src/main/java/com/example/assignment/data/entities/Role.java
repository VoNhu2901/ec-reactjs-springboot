package com.example.assignment.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Role")
@Data
@AllArgsConstructor
@Table(name = "role")
public class Role {
    @OneToMany(mappedBy = "role", cascade = { CascadeType.ALL })
    private final Set<Account> accounts;
    
    @Id
    @SequenceGenerator(name = "role_squence", sequenceName = "role_squence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_squence")
    
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;
}