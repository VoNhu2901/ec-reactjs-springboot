package com.example.assignment.data.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Actor")
@Data
@Table(name = "actor")
public class Actor {

    @OneToMany(mappedBy = "actor", cascade = { CascadeType.ALL })
    private final List<ActorItem> actorItems = new ArrayList<>();

    @Id
    @SequenceGenerator(name = "actor_squence", sequenceName = "actor_squence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actor_squence")

    @Column(name = "id", updatable = false)
    @OrderBy("id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "create_at", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime createAt;

    @Column(name = "update_at", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime updateAt;

}