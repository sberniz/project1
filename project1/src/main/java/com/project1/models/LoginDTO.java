package com.project1.models;

public class LoginDTO {
    private String username;
    private String pasword;

    public LoginDTO() {
    }

    public LoginDTO(String username, String pasword) {
        this.username = username;
        this.pasword = pasword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
}
