/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package akses;
import model.Pengguna;
import java.sql.*;
import java.util.*;

/**
 *
 * @author nicho
 */
public class PenggunaDAO {
    public static Pengguna login(String username, String password) {
        Pengguna user = null;
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM pengguna WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new Pengguna();
                user.setIdPengguna(rs.getString("id_pengguna"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setTanggalDaftar(rs.getTimestamp("tanggal_daftar"));
            }
        } catch (SQLException e) {
            System.out.println("Login gagal: " + e.getMessage());
        }
        return user;
    }

    public static List<Pengguna> getAll() {
        List<Pengguna> list = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM pengguna";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Pengguna p = new Pengguna();
                p.setIdPengguna(rs.getString("id_pengguna"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));
                p.setEmail(rs.getString("email"));
                p.setTanggalDaftar(rs.getTimestamp("tanggal_daftar"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Gagal ambil data pengguna: " + e.getMessage());
        }
        return list;
    }
}
