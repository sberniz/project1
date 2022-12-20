package com.project1.models;

public class ReimbStatus {
    private int ers_reimb_status_id;
    private String ers_reimb_status;

    public ReimbStatus() {
    }

    public ReimbStatus(int ers_reimb_status_id, String ers_reimb_status) {

        this.ers_reimb_status_id = ers_reimb_status_id;
        this.ers_reimb_status = ers_reimb_status;
    }

    public int getErs_reimb_status_id() {
        return ers_reimb_status_id;
    }

    public void setErs_reimb_status_id(int ers_reimb_status_id) {
        this.ers_reimb_status_id = ers_reimb_status_id;
    }

    public String getErs_reimb_status() {
        return ers_reimb_status;
    }

    public void setErs_reimb_status(String ers_reimb_status) {
        this.ers_reimb_status = ers_reimb_status;
    }
}
