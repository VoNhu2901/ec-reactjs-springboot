package com.example.assignment.config;

import com.google.common.collect.Sets;

import java.util.Set;

public enum WebUserRole {
    ADMIN(Sets.newHashSet(WebUserPermission.ADMIN_READ, WebUserPermission.CLIENT_READ)),
    ADMINTRAINEE(Sets.newHashSet( WebUserPermission.CLIENT_READ)),

    CLIENT(Sets.newHashSet());
    private final Set<WebUserPermission> permissions;

    WebUserRole(Set<WebUserPermission> permissions) {
        this.permissions = permissions;
    }

}
