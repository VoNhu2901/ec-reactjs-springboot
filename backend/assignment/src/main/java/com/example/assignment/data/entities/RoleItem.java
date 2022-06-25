package com.example.assignment.data.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "RoleItem")
@Data
@Table(name = "role_item")
public class RoleItem {
    @EmbeddedId
    private RoleItemId id;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "role_item_role_id_fk"))
    private Role role;

    @ManyToOne
    @MapsId("accountId")
    @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "account_item_account_id_fk"))
    private Account account;
}
