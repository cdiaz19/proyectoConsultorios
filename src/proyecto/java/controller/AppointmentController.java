/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.java.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import proyecto.java.Constants;
import proyecto.java.model.Appointment;
import proyecto.java.service.AppointmentService;

/**
 *
 * @author Yeni
 */
public class AppointmentController implements ActionListener {

    private JTextField namePatient;
    private JComboBox name;
    private JSpinnerDateEditor fecha;
    private JComboBox hora;
    private JButton accept_button;
    private JButton clean_button;

    private DateFormat dt = DateFormat.getDateInstance();

    private AppointmentService appointmentService;
    private Object[][] appointments;

    public AppointmentController(JTextField namePatient, JComboBox name, JSpinnerDateEditor fecha,
            JComboBox hora, JButton accept_button,JButton clean_button)
            throws JsonMappingException, IOException {
        super();
        this.namePatient = namePatient;
        this.name = name;
        this.fecha = fecha;
        this.hora = hora;
        this.accept_button = accept_button;
        this.clean_button = clean_button;

        appointmentService = new AppointmentService();
        appointments = appointmentService.loadAppointmentsObjWrapper();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == accept_button){
            try {
                updateAppointmentList();
            } catch (IOException ex) {
                Logger.getLogger(AppointmentController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } else if(e.getSource() == clean_button){
            try {
                cleanAll();
            } catch (IOException ex) {
                Logger.getLogger(AppointmentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void updateAppointmentList() throws IOException {
        ArrayList<Appointment> appointmentsList = new ArrayList<>();
        String namePatientTyped = namePatient.getText();
        String nameTyped = (String) name.getSelectedItem();
        String fechaTyped = fecha.getDateFormatString();
        String horaTyped = hora.getSelectedItem().toString();

        for (Object[] obj : appointments) {
            Appointment fullText
                    = new Appointment(obj[0].toString(), obj[1].toString(), obj[2].toString(), obj[3].toString());
            appointmentsList.add(fullText);
        }
        appointmentsList.add(new Appointment(namePatientTyped, nameTyped, fechaTyped, horaTyped));

        JOptionPane.showMessageDialog(null, "Se agregó " + namePatientTyped + " correctamente");

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(Constants.FILENAME_APPOINTMENT), appointmentsList);
    }
   
    private void cleanAll() throws IOException{
        namePatient.setText(" ");
        name.setSelectedItem(" ");
        fecha.setDateFormatString("");
        hora.setSelectedItem(" ");   
    }
 
}
