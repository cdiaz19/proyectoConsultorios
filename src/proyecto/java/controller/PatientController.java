/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.java.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toedter.calendar.JDateChooser;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import proyecto.java.Constants;
import proyecto.java.model.Patient;
import proyecto.java.service.PatientService;

/**
 *
 * @author cristian
 */
public class PatientController implements ActionListener {

    private JTextField user;
    private JPasswordField password;
    private JTextField name;
    private JTextField phone_number;
    private JTextField address;
    private JDateChooser birthday;
    private JTextField associatedDiseases;
    private JTextArea observations;
    private JButton accept_form;

    private PatientService patientService;
    private Object[][] patients;

    /**
     *
     * @param user
     * @param password
     * @param name
     * @param phone_number
     * @param address
     * @param birthday
     * @param associatedDiseases
     * @param observations
     * @param accept_form
     * @throws JsonMappingException
     * @throws IOException
     */
    public PatientController(JTextField user, JPasswordField password, JTextField name, JTextField phone_number,
            JTextField address, JDateChooser birthday, JTextField associatedDiseases,
            JTextArea observations, JButton accept_form) throws JsonMappingException, IOException {
        this.user = user;
        this.password = password;
        this.name = name;
        this.phone_number = phone_number;
        this.address = address;
        this.birthday = birthday;
        this.associatedDiseases = associatedDiseases;
        this.observations = observations;
        this.accept_form = accept_form;

        patientService = new PatientService();
        patients = patientService.loadPatientObjWrapper();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            updatePatientsList();
        } catch (IOException ex) {
            Logger.getLogger(OfficeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updatePatientsList() throws IOException {
        String passwordLogin = new String(password.getPassword());
        ArrayList<Patient> patientsList = new ArrayList<>();
        String userTyped = user.getText().toString();
        String passwordTyped = passwordLogin.toString();
        String nameTyped = name.getText().toString();
        String phoneTyped = phone_number.getText().toString();
        String addressTyped = address.getText().toString();
        String birthdayTyped = birthday.getDateFormatString();
        String associatedDiseasesTyped = associatedDiseases.getText().toString();
        String observationsTyped = observations.getText().toString();

        for (Object[] obj : patients) {
            Patient fullText = new Patient(obj[0].toString(), obj[1].toString(),
                    obj[2].toString(), obj[3].toString(), obj[4].toString(), obj[5].toString(),
                    obj[6].toString(), obj[7].toString());
            patientsList.add(fullText);
        }

        patientsList.add(new Patient(userTyped, passwordTyped, nameTyped, phoneTyped, addressTyped, birthdayTyped,
                associatedDiseasesTyped, observationsTyped));
        JOptionPane.showMessageDialog(null,
                "Se agregó " + nameTyped + " correctamente");

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(Constants.FILENAME_PATIENT), patientsList);
    }
}
