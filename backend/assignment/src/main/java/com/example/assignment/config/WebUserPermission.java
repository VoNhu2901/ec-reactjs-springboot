package com.example.assignment.config;

public enum WebUserPermission {
    CLIENT_READ("client:read"),
    CLIENT_WRITE("client:write"),
    ADMIN_READ("admin:write");

    private final String permission;

    WebUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission(){
        return permission;
    }
}
