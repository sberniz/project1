package com.project1.daos;

import com.project1.models.Employee;
import com.project1.models.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAO {
    public Employee login(String username, String password) {
        try (Connection conn = com.revature.utils.ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM ers_users WHERE ers_username = ? AND ers_password = ?;";
            System.out.println(username+" \n"+password);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Employee e = new Employee(
                        rs.getInt("ers_user_id"),
                        rs.getString("ers_first_name"),
                        rs.getString("ers_last_name"),
                        null
                );
                int roleFK = rs.getInt("ers_role_id_fk");
                RoleDAO rdao = new RoleDAO();

                Role r = rdao.getRoleById(roleFK);
                e.setRole(r);
                return e;

            }
            else{
                System.out.println("NOne");
                return  null;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
