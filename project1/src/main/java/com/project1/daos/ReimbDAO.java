package com.project1.daos;

import com.project1.models.*;

import java.sql.*;
import java.util.ArrayList;

public class ReimbDAO implements ReimbDAOInterface{

    @Override
    public ArrayList<Reimbursement> getReimbursement(int emp_id, int role_id) {
        //for manager role get all Reimbursement
        try(Connection conn = com.revature.utils.ConnectionUtil.getConnection()){
            String sql;
            PreparedStatement ps;


            if(role_id == 1){
                sql = "SELECT * FROM ers_reimbursement WHERE ers_reimb_status_fk = 1";
                ps = conn.prepareStatement(sql);


            }
            else{
                sql = "SELECT * FROM ers_reimbursement WHERE ers_users_fk = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1,emp_id);

            }
            System.out.println("Emp ID"+emp_id+"  \nRole id: "+role_id);

            ResultSet rs = ps.executeQuery();
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

    @Override
    public Reimbursement submitReimbursement(Reimbursement reimb) {
        try(Connection conn = com.revature.utils.ConnectionUtil.getConnection()){
            String sql = "INSERT INTO ers_reimbursement(ers_reimb_amount,ers_reimb_description,ers_users_fk,ers_reiimb_type_fk,ers_reimb_status_fk)" +
                    "VALUES (?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,reimb.getErs_reimb_amount());
            ps.setString(2,reimb.getErs_reimb_description());
            ps.setInt(3,reimb.getErs_users_fk());
            ps.setInt(4,reimb.getErs_reimb_type_fk());
            ps.setInt(5,1);
            ps.executeUpdate();
            return reimb;

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
