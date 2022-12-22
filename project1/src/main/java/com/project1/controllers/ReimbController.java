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
        if(body.equals("")){
            ctx.result("Body Can't be Empty Please add amount and description");
            ctx.status(403);
        }
        else {


        Reimbursement reimb = gson.fromJson(body,Reimbursement.class);
        if(reimb.getErs_reimb_amount() == 0 || reimb.getErs_reimb_description() == null){
            ctx.result("Must enter amount and description to proces ticket");
            ctx.status(403);
        }
        else {


            if ((Integer) ses.getAttribute("ses_role_id") != 1 || (reimb.getErs_users_fk() == 0 || reimb.getErs_users_fk() > 3)) {
                reimb.setErs_users_fk((Integer) ses.getAttribute("ses_emp_id"));

            }
            if (reimb.getErs_reimb_type_fk() == 0 || reimb.getErs_reimb_type_fk() > 3) {
                reimb.setErs_reimb_type_fk(3);
            }
            if (reimbDAO.submitReimbursement(reimb) != null) {
                String sub = "Submission processed successfully\n Amount: "+reimb.getErs_reimb_amount()+"\nDescription: "+reimb.getErs_reimb_description();
                ctx.result(sub);
                ctx.status(202);
            }
            else{
                ctx.result("Something went wrong");
                ctx.status(500);
            }
        }

        }
        }
        else{
            ctx.result("Please Login First");
            ctx.status(403);
        }

    };
    public Handler processReimbHandler = (ctx) ->{
        if(AuthController.ses != null){
            int role_id = (Integer) ses.getAttribute("ses_role_id");
            if(role_id == 1) {


                int reimb_id = Integer.parseInt(ctx.pathParam("reimb_id"));
                int status_fk = Integer.parseInt(ctx.body());
                if (status_fk != 2 && status_fk != 3) {
                    String body = ctx.body();
                    ctx.result("Status not available *use 2 for approve and 3 to deny");
                    System.out.println(status_fk == 2);

                    ctx.status(403);
                } else {


                if (reimbDAO.process_reimb(reimb_id, status_fk,ctx) == true) {
                    ctx.status(202);

                } else {
                    ctx.status(403);
                }
            }
        }
            else{
                ctx.result("You must be a manager to do this process");
                ctx.status(403);
            }
        }

        else{
            ctx.result("Please Login First");
            ctx.status(403);
        }
    };
}
