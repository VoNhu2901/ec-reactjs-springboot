package com.example.assignment.models;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity(name = "Role")
@Getter
@Setter
@NoArgsConstructor
@Table(name = "role")
public class Role {
  @Id
  @SequenceGenerator(name = "role_squence", sequenceName = "role_squence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_squence")
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "name", nullable = false, columnDefinition = "TEXT")
  private String name;
}