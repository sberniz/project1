package com.project1.models;

public class Employee {
    private int ers_user_id;
    private String ers_username;
    private String ers_password;
    private String ers_first_name;
    private String ers_last_name;
    private Role role;
    private int role_id_fk;

    public Employee() {
    }

    public Employee(int ers_user_id, String ers_username, String ers_password, String ers_first_name, String ers_last_name, Role role, int role_id_fk) {
        this.ers_user_id = ers_user_id;
        this.ers_username = ers_username;
        this.ers_password = ers_password;
        this.ers_first_name = ers_first_name;
        this.ers_last_name = ers_last_name;
        this.role = role;
        this.role_id_fk = role_id_fk;
    }
//employee without entire role object
    public Employee(int ers_user_id, String ers_username, String ers_password, String ers_first_name, String ers_last_name, int role_id_fk) {
        this.ers_user_id = ers_user_id;
        this.ers_username = ers_username;
        this.ers_password = ers_password;
        this.ers_first_name = ers_first_name;
        this.ers_last_name = ers_last_name;
        this.role_id_fk = role_id_fk;
    }

    public Employee(int ers_user_id, String ers_username, String ers_password, String ers_first_name, String ers_last_name, Role role) {
        this.ers_user_id = ers_user_id;
        this.ers_username = ers_username;
        this.ers_password = ers_password;
        this.ers_first_name = ers_first_name;
        this.ers_last_name = ers_last_name;
        this.role = role;
    }

    public Employee(int ers_user_id, String ers_first_name, String ers_last_name, Role role) {
        this.ers_user_id = ers_user_id;
        this.ers_first_name = ers_first_name;
        this.ers_last_name = ers_last_name;
        this.role = role;
    }

    public int getErs_user_id() {
        return ers_user_id;
    }

    public void setErs_user_id(int ers_user_id) {
        this.ers_user_id = ers_user_id;
    }

    public String getErs_username() {
        return ers_username;
    }

    public void setErs_username(String ers_username) {
        this.ers_username = ers_username;
    }

    public String getErs_password() {
        return ers_password;
    }

    public void setErs_password(String ers_password) {
        this.ers_password = ers_password;
    }

    public String getErs_first_name() {
        return ers_first_name;
    }

    public void setErs_first_name(String ers_first_name) {
        this.ers_first_name = ers_first_name;
    }

    public String getErs_last_name() {
        return ers_last_name;
    }

    public void setErs_last_name(String ers_last_name) {
        this.ers_last_name = ers_last_name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getRole_id_fk() {
        return role_id_fk;
    }

    public void setRole_id_fk(int role_id_fk) {
        this.role_id_fk = role_id_fk;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ers_user_id=" + ers_user_id +
                ", ers_username='" + ers_username + '\'' +
                ", ers_password='" + ers_password + '\'' +
                ", ers_first_name='" + ers_first_name + '\'' +
                ", ers_last_name='" + ers_last_name + '\'' +
                ", role=" + role +
                ", role_id_fk=" + role_id_fk +
                '}';
    }
}
