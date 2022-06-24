package com.example.assignment.data.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;

import lombok.*;

@Entity(name = "Invoice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoice")
public class Invoice {
  @Id
  @SequenceGenerator(name = "invoice_squence", sequenceName = "invoice_squence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_squence")
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "amount", nullable = false)
  private Integer amount;

  @Column(name = "create_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private LocalDateTime createAt;

  @Column(name = "update_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private LocalDateTime updateAt;

  @OneToMany(mappedBy = "invoice", cascade = { CascadeType.PERSIST,
  CascadeType.REMOVE })
  private final List<InvoiceItem> invoiceItems = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "account_id", nullable = false, referencedColumnName =
  "id", foreignKey = @ForeignKey(name = "account_invoice_fk"))
  private Account account;
}