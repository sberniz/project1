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
        Gson gson = new Gson();
        Employee emp = gson.fromJson(body, Employee.class);
        if(eDAO.insertEmployee(emp) != null){
            ctx.status(201);
            ctx.result(body);
        }
        else{
            ctx.status(406);
        }


    };

}
