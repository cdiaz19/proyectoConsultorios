/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.proyecto.java.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static ac.cr.una.proyecto.java.Constants.ACTUAL;
import ac.cr.una.proyecto.java.model.Patient;
import ac.cr.una.proyecto.java.service.LoginPatientService;
import ac.cr.una.proyecto.java.view.LoginView;
import ac.cr.una.proyecto.java.view.PatientPanelView;
import ac.cr.una.proyecto.java.view.PrincipalPanelView;
import com.fasterxml.jackson.databind.JsonMappingException;

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
    private ArrayList<Patient> loginList;

    /**
     *
     * @param txtUsername
     * @param txtPassword
     * @param btnLogin
     * @param btnSalir
     * @throws com.fasterxml.jackson.databind.JsonMappingException
     * @throws IOException
     */
    public LoginController(JTextField txtUsername, JPasswordField txtPassword, JButton btnLogin,
            JButton btnSalir) throws JsonMappingException, IOException  {
        this.txtUsername = txtUsername;
        this.txtPassword = txtPassword;
        this.btnLogin = btnLogin;
        this.btnSalir = btnSalir;
        loginList = new ArrayList<>();
        loginPatientService = new LoginPatientService();
        patients = loginPatientService.loadOfficesObjWrapper();

        /*for (Object obj[] : patients) {
            Patient fullText;
            fullText = new Patient(obj[0].toString(), obj[1].toString());
            loginList.add(fullText);
        }*/

    }

    /**
     *
     */
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

    /**
     *
     * @param username
     * @param password
     * @throws IOException
     */
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

    /**
     *
     * @param username
     * @param password
     * @throws IOException
     */
    public void comparePatientInRegister(String username, String password) throws IOException {
        boolean isUser = false;
        for (int i = 0; i < loginList.size(); i++) {
            String user = loginList.get(i).getUser();
            String pass = loginList.get(i).getPassword();
            if (username.equals(user) && password.equals(pass)) {
                ACTUAL = loginList.get(i).getUser();
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

}
