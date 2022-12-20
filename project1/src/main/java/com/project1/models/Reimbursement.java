package com.project1.models;

public class Reimbursement {
    private int ers_reimb_id;
    private int ers_reimb_amount;
    private String ers_reimb_description;
    private Employee emp;
    private ReimbType reimbtype;
    private ReimbStatus reimbstatus;

    public Reimbursement() {
    }

    public Reimbursement(int ers_reimb_id, int ers_reimb_amount, String ers_reimb_description, Employee emp, ReimbType reimbtype, ReimbStatus reimbstatus) {
        this.ers_reimb_id = ers_reimb_id;
        this.ers_reimb_amount = ers_reimb_amount;
        this.ers_reimb_description = ers_reimb_description;
        this.emp = emp;
        this.reimbtype = reimbtype;
        this.reimbstatus = reimbstatus;
    }

    public int getErs_reimb_id() {
        return ers_reimb_id;
    }

    public void setErs_reimb_id(int ers_reimb_id) {
        this.ers_reimb_id = ers_reimb_id;
    }

    public int getErs_reimb_amount() {
        return ers_reimb_amount;
    }

    public void setErs_reimb_amount(int ers_reimb_amount) {
        this.ers_reimb_amount = ers_reimb_amount;
    }

    public String getErs_reimb_description() {
        return ers_reimb_description;
    }

    public void setErs_reimb_description(String ers_reimb_description) {
        this.ers_reimb_description = ers_reimb_description;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public ReimbType getReimbtype() {
        return reimbtype;
    }

    public void setReimbtype(ReimbType reimbtype) {
        this.reimbtype = reimbtype;
    }

    public ReimbStatus getReimbstatus() {
        return reimbstatus;
    }

    public void setReimbstatus(ReimbStatus reimbstatus) {
        this.reimbstatus = reimbstatus;
    }
}
