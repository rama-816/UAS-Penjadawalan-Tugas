/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package akses;
import model.KategoriTugas;
import java.sql.*;
import java.util.*;

/**
 *
 * @author nicho
 */
public class KategoriDAO {
    public static List<KategoriTugas> getAll() {
        List<KategoriTugas> list = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM kategori_tugas";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                KategoriTugas kt = new KategoriTugas();
                kt.setIdKategori(rs.getString("id_kategori"));
                kt.setNamaKategori(rs.getString("nama_kategori"));
                list.add(kt);
            }
        } catch (SQLException e) {
            System.out.println("Gagal ambil data kategori: " + e.getMessage());
        }
        return list;
    }

    public static void insert(KategoriTugas kt) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO kategori_tugas (id_kategori, nama_kategori) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kt.getIdKategori());
            ps.setString(2, kt.getNamaKategori());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal insert kategori: " + e.getMessage());
        }
    }

    public static void update(KategoriTugas kt) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE kategori_tugas SET nama_kategori = ? WHERE id_kategori = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kt.getNamaKategori());
            ps.setString(2, kt.getIdKategori());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal update kategori: " + e.getMessage());
        }
    }

    public static void delete(String idKategori) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "DELETE FROM kategori_tugas WHERE id_kategori = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idKategori);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal hapus kategori: " + e.getMessage());
        }
    }

    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
