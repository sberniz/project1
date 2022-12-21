package com.project1.controllers;

import com.google.gson.Gson;
import com.project1.daos.EmployeeDAO;
import com.project1.models.Employee;
import io.javalin.http.Handler;

public class EmployeeController {
    EmployeeDAO eDAO = new EmployeeDAO();
    //Insert Employee Handler (Register)
    public Handler insertEmployeeHandler = (ctx) ->{
        String body = ctx.body();
        System.out.println(body);
        if(body.equals("")){
            ctx.result("Body Can't be Empty Must Have Username and Password");
            ctx.status(404);
        }
        else{

        Gson gson = new Gson();
        Employee emp = gson.fromJson(body, Employee.class);
            if(emp.getErs_username() == null || emp.getErs_password() == null){
                ctx.result("Either Username or Password is blank must register with username and password");

            }
            else {


        if(eDAO.insertEmployee(emp,ctx) != null){
            ctx.status(201);
            String welcome = emp.getErs_username()+" Registered Successfully";
            ctx.result(welcome);
        }
        else{
            ctx.status(406);
        }
            }

        }


    };

}
