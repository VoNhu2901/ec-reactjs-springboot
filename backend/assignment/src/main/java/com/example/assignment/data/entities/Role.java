package com.example.assignment.data.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
public class Role {
    @OneToMany(mappedBy = "role", cascade = {CascadeType.PERSIST,
            CascadeType.REMOVE})
    private final List<RoleItem> roleItems = new ArrayList<>();
    @Id
    @SequenceGenerator(name = "role_squence", sequenceName = "role_squence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_squence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;
}