package com.example.assignment.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Actor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actor")
public class Actor {

    @OneToMany(mappedBy = "actor", cascade = {CascadeType.PERSIST,
            CascadeType.REMOVE})
    private final List<ActorItem> actorItems = new ArrayList<>();
    @Id
    @SequenceGenerator(name = "actor_squence", sequenceName = "actor_squence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actor_squence")
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
    private String firstName;
    @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
    private String lastName;
    @Column(name = "email", nullable = false, columnDefinition = "TEXT")
    private String email;
    @Column(name = "password", nullable = false, columnDefinition = "TEXT")
    private String password;
    @Column(name = "avatar", nullable = true, columnDefinition = "TEXT")
    private String avatar;
    @Column(name = "phone", nullable = false, columnDefinition = "TEXT")
    private String phone;
    @Column(name = "create_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime createAt;
    @Column(name = "update_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime updateAt;

}