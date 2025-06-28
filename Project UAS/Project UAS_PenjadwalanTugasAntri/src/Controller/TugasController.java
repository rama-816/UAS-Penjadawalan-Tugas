/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;
import model.Tugas;
import Akses.TugasDAO;

import java.util.List;

public class TugasController {
     public List<Tugas> getAllTugas() {
        return TugasDAO.getAllTugas();
    }

    public boolean saveTugas(Tugas newTugas) {
        try {
            TugasDAO.addTugas(newTugas);
            return true;
        } catch (Exception e) {
            System.err.println("Gagal simpan tugas: " + e.getMessage());
            return false;
        }
    }

    public boolean updateTugas(Tugas updatedTugas) {
        try {
            TugasDAO.updateTugas(updatedTugas);
            return true;
        } catch (Exception e) {
            System.err.println("Gagal update tugas: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteTugas(int idTugas) {
        try {
            TugasDAO.deleteTugas(idTugas);
            return true;
        } catch (Exception e) {
            System.err.println("Gagal hapus tugas: " + e.getMessage());
            return false;
        }
    }
}
