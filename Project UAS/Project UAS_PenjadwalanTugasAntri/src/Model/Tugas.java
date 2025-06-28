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
public class Tugas {
    private Integer idTugas;
    private Pengguna pengguna;
    private String judulTugas;
    private String deskripsiTugas;
    private Date tanggalTribut;
    private Date tanggalSelesai;
    private String prioritas;
    private String statusTugas;
    private KategoriTugas kategori;
    
    public Tugas() {}
     public Tugas(Integer idTugas, Pengguna pengguna, String judulTugas, String deskripsiTugas,
                 Date tanggalTribut, Date tanggalSelesai, String prioritas, String statusTugas, KategoriTugas kategori) {
        this.idTugas = idTugas;
        this.pengguna = pengguna;
        this.judulTugas = judulTugas;
        this.deskripsiTugas = deskripsiTugas;
        this.tanggalTribut = tanggalTribut;
        this.tanggalSelesai = tanggalSelesai;
        this.prioritas = prioritas;
        this.statusTugas = statusTugas;
        this.kategori = kategori;
    }

    // --- Getters ---
    public Integer getIdTugas() { return idTugas; }
    public Pengguna getPengguna() { return pengguna; }
    public String getJudulTugas() { return judulTugas; }
    public String getDeskripsiTugas() { return deskripsiTugas; }
    public Date getTanggalTribut() { return tanggalTribut; }
    public Date getTanggalSelesai() { return tanggalSelesai; }
    public String getPrioritas() { return prioritas; }
    public String getStatusTugas() { return statusTugas; }
    public KategoriTugas getKategori() { return kategori; }

    // --- Setters ---
    public void setIdTugas(Integer idTugas) { this.idTugas = idTugas; }
    public void setPengguna(Pengguna pengguna) { this.pengguna = pengguna; }
    public void setJudulTugas(String judulTugas) { this.judulTugas = judulTugas; }
    public void setDeskripsiTugas(String deskripsiTugas) { this.deskripsiTugas = deskripsiTugas; }
    public void setTanggalTribut(Date tanggalTribut) { this.tanggalTribut = tanggalTribut; }
    public void setTanggalSelesai(Date tanggalSelesai) { this.tanggalSelesai = tanggalSelesai; }
    public void setPrioritas(String prioritas) { this.prioritas = prioritas; }
    public void setStatusTugas(String statusTugas) { this.statusTugas = statusTugas; }
    public void setKategori(KategoriTugas kategori) { this.kategori = kategori; }

    public Object getBatasWaktu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setBatasWaktu(Date batasWaktuDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
