package com.project1.models;

public class ReimbType {
    private int ers_reimb_type_id;
    private String ers_reimb_type;

    public ReimbType() {
    }

    public ReimbType(int ers_reimb_type_id, String ers_reimb_type) {
        this.ers_reimb_type_id = ers_reimb_type_id;
        this.ers_reimb_type = ers_reimb_type;
    }

    public int getErs_reimb_type_id() {
        return ers_reimb_type_id;
    }

    public void setErs_reimb_type_id(int ers_reimb_type_id) {
        this.ers_reimb_type_id = ers_reimb_type_id;
    }

    public String getErs_reimb_type() {
        return ers_reimb_type;
    }

    public void setErs_reimb_type(String ers_reimb_type) {
        this.ers_reimb_type = ers_reimb_type;
    }
}
