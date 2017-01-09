/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.java.view;

import com.toedter.calendar.JDateChooser;
import java.awt.FlowLayout;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import proyecto.java.controller.PatientController;

/**
 *
 * @author cristian
 */
public class AddPatientView extends JInternalFrame {

    JTextField user = new JTextField(15);
    JPasswordField password = new JPasswordField(15);
    JTextField name = new JTextField(15);
    JTextField phone_number = new JTextField(15);
    JTextField address = new JTextField(15);
    JDateChooser birthday = new JDateChooser();
    JTextField associatedDiseases = new JTextField(15);
    JTextArea observations = new JTextArea(4, 15);
    JButton accept_form = new JButton("Aceptar");

    public AddPatientView() throws IOException {
        super("Formulario Nuevo Paciente", false, true, false, true);
        setSize(220, 560);

        // Create controller
        PatientController controller
                = new PatientController(user, password, name, phone_number, address, birthday,
                        associatedDiseases, observations, accept_form);

        accept_form.addActionListener(controller);

        //Inicializa variables
        JPanel panel = new JPanel();
        FlowLayout lm = new FlowLayout(FlowLayout.LEFT);
        panel.setLayout(lm);
        JLabel userLabel = new JLabel("Usuario: ");
        JLabel passwordLabel = new JLabel("Contraseña: ");
        JLabel nameLabel = new JLabel("Nombre: ");
        JLabel phonenumberLabel = new JLabel("Telefono: ");
        JLabel addressLabel = new JLabel("Direccion: ");
        JLabel birthdayLabel = new JLabel("Fecha Nacimiento: ");
        JLabel associatedDiseasesLabel = new JLabel("Enfermedades: ");
        JLabel observationLabel = new JLabel("Observaciones del Paciente: ");

        //setea nombres (ids)
        userLabel.setName("lblUser");
        passwordLabel.setName("lblPassword");
        nameLabel.setName("lblName");
        phonenumberLabel.setName("lblPhone");
        addressLabel.setName("lblAddress");
        birthdayLabel.setName("lblBirthday");
        associatedDiseasesLabel.setName("lblAssociatedDiseases");
        observationLabel.setName("lblObservation");

        observations.setLineWrap(true);
        observations.setWrapStyleWord(true);

        user.setName("user");
        password.setName("password");
        name.setName("name");
        phone_number.setName("phone");
        address.setName("address");
        birthday.setName("birthday");
        associatedDiseases.setName("associatedDiseases");
        observations.setName("observations");
        accept_form.setName("ok");

        //Las agrega al Panel
        panel.setName("Form");
        panel.add(userLabel);
        panel.add(user);
        panel.add(passwordLabel);
        panel.add(password);
        panel.add(nameLabel);
        panel.add(name);
        panel.add(phonenumberLabel);
        panel.add(phone_number);
        panel.add(addressLabel);
        panel.add(address);
        panel.add(birthdayLabel);
        panel.add(birthday);
        panel.add(associatedDiseasesLabel);
        panel.add(associatedDiseases);
        panel.add(observationLabel);
        panel.add(observations);
        panel.add(accept_form);

        add(panel);
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        AddPatientView.setLookAndFeel();
        AddPatientView fu = new AddPatientView();
    }

}
