package com.project1.daos;

import com.project1.models.Employee;
import io.javalin.http.Context;

public interface EmployeeDAOInterface {

    //Register Employee
    //(Insert DB)
    Employee insertEmployee(Employee emp, Context ctx); //register
    Employee getEmployeeById(int id);

    //if role is manager. view pending tickets?



    //login employee
    //(Login Feature)
    //submit ticket
    //JOin inesrts

    //view past tickets
    //select joins

    //Submit Ticket
    //if role is manager, view list and approve/deny

    //view submitted tickets
}
