package com.project1.controllers;

import com.google.gson.Gson;
import com.project1.daos.AuthDAO;
import com.project1.models.Employee;
import com.project1.models.LoginDTO;
import io.javalin.http.Handler;

import javax.servlet.http.HttpSession;

public class AuthController {
    AuthDAO auth = new AuthDAO();
    public static HttpSession ses;
    public Handler loginHandler = (ctx) ->{
        String body = ctx.body();
        Gson gson = new Gson();
        LoginDTO ldto = gson.fromJson(body,LoginDTO.class);
        Employee loginEmployee = auth.login(ldto.getUsername(), ldto.getPassword());
        if(loginEmployee != null){
            ses = ctx.req.getSession();
            ses.setAttribute("ses_emp_id",loginEmployee.getErs_user_id());
            ses.setAttribute("ses_role_id",loginEmployee.getRole().getRole_id());


            String usergson = gson.toJson(loginEmployee);
            ctx.result(usergson);
            ctx.status(202);
        }
        else{
            ctx.status(403);
        }

    };

}
