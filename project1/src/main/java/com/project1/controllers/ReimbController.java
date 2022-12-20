package com.project1.controllers;

import com.google.gson.Gson;
import com.project1.daos.ReimbDAO;
import com.project1.models.Reimbursement;
import io.javalin.http.Handler;

import java.util.ArrayList;

import static com.project1.controllers.AuthController.ses;

public class ReimbController {
    ReimbDAO reimbDAO = new ReimbDAO();
    public Handler getReimbursementHandler = (ctx) ->{
        if(ses != null){



        ArrayList<Reimbursement> reimb = reimbDAO.getReimbursement((Integer) ses.getAttribute("ses_emp_id"),(Integer) ses.getAttribute("ses_role_id"));
        Gson gson = new Gson();
        String jsonReimb = gson.toJson(reimb);
        ctx.result(jsonReimb);
        ctx.status(202);
        }
        else{
            ctx.result("Please Login first");
            ctx.status(403);

            }

    };
    public Handler submtReimbursementHandler = (ctx) ->{
        if(AuthController.ses != null){


        String body = ctx.body();
        Gson gson = new Gson();
        Reimbursement reimb = gson.fromJson(body,Reimbursement.class);
        if(reimbDAO.submitReimbursement(reimb) != null){
            ctx.result(body);
            ctx.status(202);
        }
        }
        else{
            ctx.result("Please Login First");
            ctx.status(403);
        }

    };
}
