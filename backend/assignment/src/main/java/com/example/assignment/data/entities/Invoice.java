package com.example.assignment.data.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Invoice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoice")
public class Invoice {
    @OneToMany(mappedBy = "invoice", cascade = {CascadeType.PERSIST,
            CascadeType.REMOVE})
    private final List<InvoiceItem> invoiceItems = new ArrayList<>();
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
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false, referencedColumnName =
            "id", foreignKey = @ForeignKey(name = "account_invoice_fk"))
    private Account account;
}