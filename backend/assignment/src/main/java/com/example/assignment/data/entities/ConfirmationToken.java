package com.example.assignment.data.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.example.assignment.services.impl.UserDetailsImpl;

import lombok.*;

@Entity
@Table(name = "confirmation_token")
@NoArgsConstructor
@Data
public class ConfirmationToken {
  

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String token;

  @Column(nullable = false, name = "create_at")
  private LocalDateTime createAt;

  @Column(nullable = false, name = "expired_at")
  private LocalDateTime expiredAt;

  @Column(nullable = true, name = "confirmed_at")
  private LocalDateTime confirmedAt;

  @ManyToOne
  @JoinColumn(nullable = false, name = "user_id")
  private UserDetailsImpl user;

  public ConfirmationToken(String token, LocalDateTime createAt, LocalDateTime expiredAt, UserDetailsImpl user) {
    this.token = token;
    this.createAt = createAt;
    this.expiredAt = expiredAt;
    this.user = user;
  }
}
