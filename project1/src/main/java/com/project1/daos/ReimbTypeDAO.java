package com.project1.daos;

import com.project1.models.ReimbType;
import com.project1.models.Reimbursement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReimbTypeDAO implements ReimbTypeDAOInterface{
    @Override
    public ReimbType getReimbTypeById(int id) {
        try(Connection conn = com.revature.utils.ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM ers_reimbursement_type WHERE ers_reimb_type_id=?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ReimbType reimbtype = new ReimbType(rs.getInt("ers_reimb_type_id"),rs.getString("ers_reimb_type"));
                return reimbtype;
            }


        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;

    }
}
