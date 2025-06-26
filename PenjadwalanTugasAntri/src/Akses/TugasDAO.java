/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Akses;
import model.Tugas;
import model.Pengguna;
import model.KategoriTugas;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import akses.DatabaseConnection;
/**
 *
 * @author nicho
 */
public class TugasDAO {
     public static List<Tugas> getAllTugas() {
        List<Tugas> list = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM tugas";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Tugas t = new Tugas();
                t.setIdTugas(rs.getInt("id_tugas"));
                t.setJudulTugas(rs.getString("judul_tugas"));
                t.setDeskripsiTugas(rs.getString("deskripsi_tugas"));
                t.setTanggalTribut(rs.getTimestamp("tanggal_dibuat"));
                t.setTanggalSelesai(rs.getTimestamp("batas_waktu"));
                t.setPrioritas(rs.getString("prioritas"));
                t.setStatusTugas(rs.getString("status_tugas"));

                Pengguna pengguna = new Pengguna(null, null, null, null, null);
                pengguna.setIdPengguna(rs.getString("id_pengguna"));
                t.setPengguna(pengguna);

                KategoriTugas kategori = new KategoriTugas();
                kategori.setIdKategori(rs.getString("id_kategori"));
                t.setKategori(kategori);

                list.add(t);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Gagal ambil data tugas: " + e.getMessage());
        }
        return list;
    }

    public static void addTugas(Tugas t) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO tugas (id_tugas, id_pengguna, judul_tugas, deskripsi_tugas, tanggal_dibuat, batas_waktu, prioritas, status_tugas, id_kategori) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            if (t.getIdTugas() != null) {
                ps.setInt(1, t.getIdTugas());
            } else {
                ps.setNull(1, Types.INTEGER);
            }

            if (t.getPengguna() != null && t.getPengguna().getIdPengguna() != null) {
                ps.setString(2, t.getPengguna().getIdPengguna());
            } else {
                ps.setNull(2, Types.VARCHAR);
            }

            ps.setString(3, t.getJudulTugas());
            ps.setString(4, t.getDeskripsiTugas());
            ps.setTimestamp(5, new Timestamp(t.getTanggalTribut().getTime()));

            if (t.getTanggalSelesai() != null) {
                ps.setTimestamp(6, new Timestamp(t.getTanggalSelesai().getTime()));
            } else {
                ps.setNull(6, Types.TIMESTAMP);
            }

            ps.setString(7, t.getPrioritas());
            ps.setString(8, t.getStatusTugas());

            if (t.getKategori() != null && t.getKategori().getIdKategori() != null) {
                ps.setString(9, t.getKategori().getIdKategori());
            } else {
                ps.setNull(9, Types.INTEGER);
            }

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Gagal insert tugas: " + e.getMessage());
        }
    }

    public static void updateTugas(Tugas t) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE tugas SET id_pengguna=?, judul_tugas=?, deskripsi_tugas=?, tanggal_dibuat=?, batas_waktu=?, prioritas=?, status_tugas=?, id_kategori=? WHERE id_tugas=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            if (t.getPengguna() != null && t.getPengguna().getIdPengguna() != null) {
                ps.setString(1, t.getPengguna().getIdPengguna());
            } else {
                ps.setNull(1, Types.VARCHAR);
            }

            ps.setString(2, t.getJudulTugas());
            ps.setString(3, t.getDeskripsiTugas());
            ps.setTimestamp(4, new Timestamp(t.getTanggalTribut().getTime()));

            if (t.getTanggalSelesai() != null) {
                ps.setTimestamp(5, new Timestamp(t.getTanggalSelesai().getTime()));
            } else {
                ps.setNull(5, Types.TIMESTAMP);
            }

            ps.setString(6, t.getPrioritas());
            ps.setString(7, t.getStatusTugas());

            if (t.getKategori() != null && t.getKategori().getIdKategori() != null) {
                ps.setString(8, t.getKategori().getIdKategori());
            } else {
                ps.setNull(8, Types.INTEGER);
            }

            ps.setInt(9, t.getIdTugas());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Gagal update tugas: " + e.getMessage());
        }
    }

    public static void deleteTugas(int idTugas) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "DELETE FROM tugas WHERE id_tugas=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idTugas);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Gagal hapus tugas: " + e.getMessage());
        }
    }

    private static Object getKategori() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
