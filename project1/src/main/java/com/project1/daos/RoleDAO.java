package com.project1.daos;

import com.project1.models.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAO implements RoleDAOInterface{

    @Override
    public Role getRoleById(int id) {
        try(Connection conn = com.revature.utils.ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM ers_user_roles WHERE ers_role_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Role role = new Role(rs.getInt("ers_role_id"),rs.getString("ers_role"));
                return role;

            }


        }
        catch(SQLException e){
            e.printStackTrace();

        }
        return null;
    }
}
