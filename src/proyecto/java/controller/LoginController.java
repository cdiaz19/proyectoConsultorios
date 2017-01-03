/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.java.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import proyecto.java.view.LoginView;
import proyecto.java.view.PatientPanelView;
import proyecto.java.view.PrincipalPanelView;

/**
 *
 * @author Kimberly
 */
public class LoginController implements ActionListener {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnSalir;

    /**
     *
     * @param txtUsername
     * @param txtPassword
     * @param btnLogin
     * @param btnSalir
     * @throws IOException
     */
    public LoginController(JTextField txtUsername, JPasswordField txtPassword, JButton btnLogin,
            JButton btnSalir) throws IOException {
        this.txtUsername = txtUsername;
        this.txtPassword = txtPassword;
        this.btnLogin = btnLogin;
        this.btnSalir = btnSalir;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        if (source == btnLogin) {
            try {
                compare(username, password);
            } catch (IOException ex) {
                Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (source == btnSalir) {
            System.exit(0);
        }
    }

    /**
     *
     * @param username
     * @param password
     * @throws IOException
     */
    public void compare(String username, String password) throws IOException {
        if (txtUsername.getText().equals("Admin")) {
            if (password.equals("1234")) {
                PrincipalPanelView principalView = new PrincipalPanelView();
                principalView.setVisible(true);
                LoginView logView = new LoginView();
                logView.setVisible(false);
                logView.dispose();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Nombre de Usuario o Contraseña Invalidos", "Error",
                        JOptionPane.ERROR_MESSAGE);
                txtUsername.setText("");
                txtPassword.setText("");
            }
        } else {
            PatientPanelView patientView = new PatientPanelView();
            patientView.setVisible(true);
            LoginView logView = new LoginView();
            logView.setVisible(false);
            logView.dispose();
        }
    }
}
