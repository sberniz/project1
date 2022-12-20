package com.project1.daos;

import com.project1.models.ReimbStatus;
import com.project1.models.ReimbType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReimbStatusDAO implements ReimbStatusDAOInterface{
    @Override
    public ReimbStatus getReimbStatusById(int id) {
        try(Connection conn = com.revature.utils.ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM ers_reimbursement_status WHERE ers_reimb_status_id=?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ReimbStatus reimbStatus = new ReimbStatus(rs.getInt("ers_reimb_status_id"),rs.getString("ers_reimb_status"));
                return reimbStatus;
            }


        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
