package com.example.assignment.models;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity(name = "Language")
@Table(name = "language")
public class Language {
  @Id
  @SequenceGenerator(name = "moive_squence", sequenceName = "moive_squence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moive_squence")
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "name", nullable = false, columnDefinition = "TEXT")
  private String name;

  @Column(name = "last_update", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private LocalDateTime lastUpdate;
}
