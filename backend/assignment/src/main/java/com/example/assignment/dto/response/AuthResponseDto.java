package com.example.assignment.dto.response;


public class AuthResponseDto {
    private int accId;
    private String username;
    private String role;
    private String accessToken;

    /**
     * 
     */
    public AuthResponseDto() {
    }

    /**
     * @param accId
     * @param username
     * @param role
     * @param accessToken
     */
    public AuthResponseDto(int accId, String username, String role, String accessToken) {
        this.accId = accId;
        this.username = username;
        this.role = role;
        this.accessToken = accessToken;
    }

    /**
     * @return the accId
     */
    public int getAccId() {
        return accId;
    }

    /**
     * @param accId the accId to set
     */
    public void setAccId(int accId) {
        this.accId = accId;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * @param accessToken the accessToken to set
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

}
