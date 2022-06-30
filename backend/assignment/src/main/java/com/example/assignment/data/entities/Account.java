package com.example.assignment.data.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Account")
@Data
@Table(name = "account")
public class Account {
        @OneToMany(mappedBy = "account", orphanRemoval = true, cascade = { CascadeType.ALL })
        private final List<Invoice> invoices = new ArrayList<>();
        @OneToMany(mappedBy = "account", cascade = { CascadeType.ALL })
        private final List<Rating> ratings = new ArrayList<>();
        @ManyToOne
        @JoinColumn(name = "role_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "role_account_fk"))
        private Role role;
        
        @Id
        // @GeneratedValue(strategy = GenerationType.AUTO)
        @SequenceGenerator(name = "account_squence", sequenceName = "account_squence", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_squence")
        
        @Column(name = "id", updatable = false)
        private Long id;
        
        @Column(name = "first_name")
        private String firstName;
       
        @Column(name = "last_name")
        private String lastName;
       
        @Column(name = "password", length = 60)
        private String password;
       
        @Column(name = "email") //=username
        private String email;
        
        @Column(name = "avatar")
        private String avatar;
        
        @Column(name = "phone")
        private String phone;
        
        @Column(name = "address")
        private String address;

        @Column(name = "enabled")
        private boolean enabled = false;
       
        @Column(name = "create_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
        private LocalDateTime createAt;
       
        @Column(name = "update_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
        private LocalDateTime updateAt;

        public Account(String email,
                        String first_name,
                        String last_name,
                        String password,
                        Role role) {
                this.email = email;
                this.firstName = first_name;
                this.lastName = last_name;
                this.password = password;
                this.role = role;
        }

        public Account(Long id,
                        String email,
                        String firstName,
                        String lastName,
                        String password,
                        Role role) {
                this.id = id;
                this.email = email;
                this.firstName = firstName;
                this.lastName = lastName;
                this.password = password;
                this.role = role;
        }
}
