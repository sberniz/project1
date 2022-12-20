package com.project1.controllers;

import com.google.gson.Gson;
import com.project1.daos.ReimbDAO;
import com.project1.models.Reimbursement;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class ReimbController {
    ReimbDAO reimbDAO = new ReimbDAO();
    public Handler getReimbursementHandler = (ctx) ->{
        ArrayList<Reimbursement> reimb = reimbDAO.getReimbursement();
        Gson gson = new Gson();
        String jsonReimb = gson.toJson(reimb);
        ctx.result(jsonReimb);
        ctx.status(202);

    };
}
