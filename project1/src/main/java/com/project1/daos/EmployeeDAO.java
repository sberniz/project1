package com.project1.daos;

import com.project1.models.Employee;
import com.project1.models.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO implements EmployeeDAOInterface{
    @Override
    public Employee insertEmployee(Employee emp) { //Method to Register Employee
        try(Connection conn = com.revature.utils.ConnectionUtil.getConnection()){
            //Insert Register Employee
            String sql = "INSERT INTO ers_users (ers_username,ers_password,ers_first_name,ers_last_name,ers_role_id_fk)" +
                    "VALUES (?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,emp.getErs_username());
            ps.setString(2,emp.getErs_password());
            ps.setString(3,emp.getErs_first_name());
            ps.setString(4,emp.getErs_last_name());
            ps.setInt(5,emp.getRole_id_fk());
            ps.executeUpdate();
            return emp;

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee getEmployeeById(int id) {
        try(Connection conn = com.revature.utils.ConnectionUtil.getConnection()){
        //All sql connection in try block
        String sql_query = "SELECT * FROM ers_users WHERE ers_user_id=?;";
        //Prepare statement prepare quuery to be sent to the datbase
        PreparedStatement ps = conn.prepareStatement(sql_query);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery(); //Running sql statement stored in the prepare statement result will get in result object
        //while loop to retriever esults
        while(rs.next()) {
            //Use Data from Resultset to fill in all the data in the role constructore
            Employee emp = new Employee(rs.getInt("ers_user_id"),
                    null,
                    null,
                    rs.getString("ers_first_name"),
                    rs.getString("ers_last_name"),
                    null

            );
            int role_fk = rs.getInt("ers_role_id_fk");
            RoleDAO rDAO = new RoleDAO();
            Role r = rDAO.getRoleById(role_fk);
            emp.setRole(r);

            return emp; //Return employee data to user


        }


    }

    catch(SQLException e){
        e.printStackTrace(); //if somethign gos wrong it will display mesage
    }
        return null;
    }
}
