/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.util.Date;
/**
 *
 * @author nicho
 */
public class Pengguna {
    private String idPengguna;
    private String username;
    private String password;
    private String email;
    private Date tanggalDaftar;
     public Pengguna(String idPengguna, String username, String password, String email, Date tanggalDaftar) {
        this.idPengguna = idPengguna;
        this.username = username;
        this.password = password;
        this.email = email;
        this.tanggalDaftar = tanggalDaftar;
    }

    public Pengguna() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // --- Getter dan Setter ---

    public String getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(String idPengguna) {
        this.idPengguna = idPengguna;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getTanggalDaftar() {
        return tanggalDaftar;
    }

    public void setTanggalDaftar(Date tanggalDaftar) {
        this.tanggalDaftar = tanggalDaftar;
    }

    @Override
    public String toString() {
        return username; // agar combo box bisa langsung tampil nama user
    }
}