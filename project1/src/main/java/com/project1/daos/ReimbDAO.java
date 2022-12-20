package com.project1.daos;

import com.project1.models.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReimbDAO implements ReimbDAOInterface{

    @Override
    public ArrayList<Reimbursement> getReimbursement() {
        //for manager role get all Reimbursement
        try(Connection conn = com.revature.utils.ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM ers_reimbursement WHERE ers_reimb_status_fk = 1";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            ArrayList<Reimbursement> reimbursmentList = new ArrayList<>();
            while(rs.next()){
                //New Reimb Object
                Reimbursement reimb = new Reimbursement(rs.getInt("ers_reimb_id"),
                        rs.getInt("ers_reimb_amount"),
                        rs.getString("ers_reimb_description"),null,null,null
                );
                int users_fk = rs.getInt("ers_users_fk");
                EmployeeDAO eDAO = new EmployeeDAO();
                Employee emp = eDAO.getEmployeeById(users_fk);
                reimb.setEmp(emp);

                //reimbtype
                int reimb_type_fk = rs.getInt("ers_reiimb_type_fk");
                ReimbTypeDAO rtypeDAO = new ReimbTypeDAO();
                ReimbType rtype = rtypeDAO.getReimbTypeById(reimb_type_fk);
                reimb.setReimbtype(rtype);
                //reimb status
                int reimb_status_fk = rs.getInt("ers_reimb_status_fk");
                ReimbStatusDAO rstatusDAO = new ReimbStatusDAO();
                ReimbStatus rstatus = rstatusDAO.getReimbStatusById(reimb_status_fk);
                reimb.setReimbstatus(rstatus);
                reimbursmentList.add(reimb);


            }
            return reimbursmentList;
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }
}
