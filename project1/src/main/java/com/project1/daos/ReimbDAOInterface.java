package com.project1.daos;

import com.project1.models.Reimbursement;
import com.project1.models.Role;
import io.javalin.http.Context;

import java.util.ArrayList;

public interface ReimbDAOInterface {
    ArrayList<Reimbursement> getReimbursement(int emp_id, int role_id);
    Reimbursement submitReimbursement(Reimbursement reimb);
    boolean process_reimb(int reimb_id, int reimb_status, Context ctx);
}
