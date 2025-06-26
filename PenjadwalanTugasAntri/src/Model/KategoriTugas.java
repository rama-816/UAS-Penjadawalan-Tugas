/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import Controller.KategoriController;
import Controller.TugasController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KategoriTugas;
import model.Tugas;
/**
 *
 * @author nicho
 */
public class KategoriTugas {
    private String idKategori;
    private String namaKategori;

    public String getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(String idKategori) {
        this.idKategori = idKategori;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }
}
