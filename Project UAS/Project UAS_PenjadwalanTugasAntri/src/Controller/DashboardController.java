/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import model.Pengguna;
import View.DashboardFrame;

public class DashboardController {
    private DashboardFrame dashboardFrame;
    private final Pengguna penggunaAktif;

    public DashboardController(Pengguna penggunaAktif) {
        this.penggunaAktif = penggunaAktif;
        initDashboard();
    }

    private void initDashboard() {
        dashboardFrame = new DashboardFrame(penggunaAktif);
        dashboardFrame.setVisible(true);
    }

    public void showDashboard() {
        dashboardFrame.setVisible(true);
    }

    public void hideDashboard() {
        dashboardFrame.setVisible(false);
    }
 public void logout() {
        dashboardFrame.dispose(); // Tutup dashboard
        // Arahkan ke login lagi jika perlu (opsional)
 }
}
