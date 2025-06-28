/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import akses.PenggunaDAO;
import model.Pengguna;
import View.LoginFrame;
import View.DashboardFrame;
import javax.swing.*;

/**
 *
 * @author nicho
 */
public class LoginController {
    private final LoginFrame loginFrame;

    public LoginController(LoginFrame loginFrame) {
        this.loginFrame = loginFrame;
    }

    public void login() {
        String username = loginFrame.getUsername();
        String password = loginFrame.getPassword();

        Pengguna user = PenggunaDAO.login(username, password);

        if (user != null) {
            JOptionPane.showMessageDialog(loginFrame, "Login berhasil!");
            loginFrame.dispose();
            new DashboardFrame(user);
        } else {
            JOptionPane.showMessageDialog(loginFrame, "Username atau Password salah!");
        }
    }
    
}
