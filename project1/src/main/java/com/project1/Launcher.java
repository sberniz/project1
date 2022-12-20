package com.project1;

import com.project1.controllers.EmployeeController;
import com.project1.controllers.ReimbController;
import io.javalin.Javalin;

public class Launcher {
    public static void main(String[] args) {
        //Javalin App start setup
        Javalin app = Javalin.create(

                //config cors all origins
                config->{
                    config.enableCorsForAllOrigins();
                }
        ).start(3000);
        //Employee controller instantiate
        EmployeeController ec = new EmployeeController();

        //Login Feature Controller
        app.post("/register",ec.insertEmployeeHandler);
        //Instantiate Auth Controller
        //app.post(/login,uatch.loginHandler)
        //tickets controller
        ReimbController reimb = new ReimbController();
        app.get("/tickets",reimb.getReimbursementHandler);

    }
}
