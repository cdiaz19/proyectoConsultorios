/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.proyecto.java.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import ac.cr.una.proyecto.java.Constants;
import ac.cr.una.proyecto.java.model.Patient;
import ac.cr.una.proyecto.java.service.PatientService;

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
    private JButton clean_button;

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
            JTextArea observations, JButton accept_form, JButton clean_button) throws JsonMappingException, IOException {
        this.user = user;
        this.password = password;
        this.name = name;
        this.phone_number = phone_number;
        this.address = address;
        this.birthday = birthday;
        this.associatedDiseases = associatedDiseases;
        this.observations = observations;
        this.accept_form = accept_form;
        this.clean_button = clean_button;

//        patientService = new PatientService();
//        patients = patientService.loadPatientObjWrapper();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == accept_form) {
        try {
            updatePatientsList();
        } catch (IOException ex) {
            Logger.getLogger(OfficeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }else if (e.getSource() == clean_button) {
            try {
                cleanAll();
            } catch (IOException ex) {
                Logger.getLogger(AppointmentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        

    private void updatePatientsList() throws IOException {
        
        String dia = Integer.toString(birthday.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(birthday.getCalendar().get(Calendar.MONTH) + 1);
        String year = Integer.toString(birthday.getCalendar().get(Calendar.YEAR));
        String fecha = (dia + "-" + mes + "-" + year);
        
        String passwordLogin = new String(password.getPassword());
        ArrayList<Patient> patientsList = new ArrayList<>();
        String userTyped = user.getText();
        String passwordTyped = passwordLogin;
        String nameTyped = name.getText();
        String phoneTyped = phone_number.getText();
        String addressTyped = address.getText();
        String birthdayTyped = fecha;
        String associatedDiseasesTyped = associatedDiseases.getText();
        String observationsTyped = observations.getText();

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
      private void cleanAll() throws IOException {
        user.setText(" ");
        password.setText(" ");
        name.setText(" ");
        phone_number.setText(" ");
        address.setText(" ");
        birthday.setDateFormatString("");
        associatedDiseases.setText(" ");
        observations.setText(" ");
    }
}
