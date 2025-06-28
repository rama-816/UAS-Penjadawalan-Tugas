/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;
import java.util.List;
import akses.KategoriDAO;
import model.KategoriTugas;
/**
 *
 * @author nicho
 */
public class KategoriController {
 private KategoriDAO kategoriDAO;

    public KategoriController() {
        kategoriDAO = new KategoriDAO();
    }

    public void simpanKategori(KategoriTugas kategori) {
        kategoriDAO.insert(kategori);
    }

    public void hapusKategori(int id) {
        kategoriDAO.delete(id);
    }

    public void updateKategori(KategoriTugas kategori) {
        kategoriDAO.update(kategori);
    }

    public List<KategoriTugas> getAllKategori() {
        return kategoriDAO.getAll();
    }
}
