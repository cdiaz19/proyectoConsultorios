/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.java.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import proyecto.java.Constants;
import proyecto.java.model.Login;
import proyecto.java.model.Patient;
import proyecto.java.service.LoginPatientService;
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
    private LoginPatientService loginPatientService;
    private Object[][] patients;
    private ArrayList<Login> loginList;

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
        loginList = new ArrayList<>();
        loginPatientService = new LoginPatientService();
        patients = loginPatientService.loadOfficesObjWrapper();

        for (Object obj[] : patients) {
            Login fullText;
            fullText = new Login(obj[0].toString(), obj[1].toString());
            loginList.add(fullText);
        }
        
        
    }
    
    public LoginController() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        if (source == btnLogin) {
            try {
                validateUserandPassword(username, password);
            } catch (IOException ex) {
                Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (source == btnSalir) {
            System.exit(0);
        }
    }

    public void validateUserandPassword(String username, String password) throws IOException {
        if (username.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null,
                    "No se aceptan espacios en blanco." + "\n" + ""
                    + "Digite datos válidos", "Error",
                    JOptionPane.ERROR_MESSAGE);
            txtUsername.setText("");
            txtPassword.setText("");
        } else {
            compareUserAndPassword(username, password);
        }
    }

    /**
     *
     * @param username
     * @param password
     * @throws IOException
     */

    public void compareUserAndPassword(String username, String password) throws IOException {
        if (username.equals("Admin")) {
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
            comparePatientInRegister(username, password);
        }

    }

    public void comparePatientInRegister(String username, String password) throws IOException {
        boolean isUser = false;
        for (int i = 0; i < loginList.size(); i++) {
            String user = loginList.get(i).getUserName();
            String pass = loginList.get(i).getPassword();
            if (username.equals(user) && password.equals(pass)) {
                PatientPanelView patientView = new PatientPanelView();
                patientView.setVisible(true);
                LoginView logView = new LoginView();
                logView.setVisible(false);
                logView.dispose();
                isUser = true;
            }
        }
        if (isUser == false) {
            JOptionPane.showMessageDialog(null,
                    "Paciente no registrado", "Error",
                    JOptionPane.ERROR_MESSAGE);
            txtUsername.setText("");
            txtPassword.setText("");
        }
    }

    public String returnName(){
        String name= txtUsername.getText();
        return name;
    }
}
