/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.java.view;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import proyecto.java.controller.LoginController;

/**
 *
 * @author Kimberly
 */
public class LoginView extends JFrame {

    JTextField txtUsername = new JTextField(15);
    JPasswordField txtPassword = new JPasswordField(15);
    JButton btnLogin = new JButton();
    JButton btnSalir = new JButton();

    /**
     *
     * @throws IOException
     */
    public LoginView() throws IOException {
        super("Inicio de Sesion");

        setSize(300, 200);
        setLayout(new BorderLayout());

        // create icons
        ImageIcon login = new ImageIcon("Log_in.png");
        ImageIcon logout = new ImageIcon("Log_out.png");

        //create buttons
        btnLogin = new JButton("Entrar", login);
        btnSalir = new JButton("Salir", logout);

        //create controller
        LoginController logController = new LoginController(txtUsername, txtPassword, btnLogin, btnSalir);
        btnLogin.addActionListener(logController);
        btnSalir.addActionListener(logController);

        //create panel and change color
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        JPanel buttonPanel = new JPanel();

        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");

        //sets text 
        txtUsername.setName("username");
        txtPassword.setName("password");
        btnLogin.setName("Login");
        btnSalir.setName("Salir");
        usernameLabel.setName("lblUsername");
        passwordLabel.setName("lblPassword");

        //add components
        panel.setName("Form");
        panel.add(usernameLabel);
        panel.add(txtUsername);
        panel.add(passwordLabel);
        panel.add(txtPassword);
        panel.add(btnLogin);
        panel.add(btnSalir);
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            // ignore error
        }
    }

    /**
     *
     * @param args
     * @throws com.fasterxml.jackson.databind.JsonMappingException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws JsonMappingException, IOException {
        setLookAndFeel();
        LoginView loginView = new LoginView();
    }
}
