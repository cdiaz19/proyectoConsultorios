/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.proyecto.java.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import ac.cr.una.proyecto.java.model.Appointment;
import ac.cr.una.proyecto.java.model.Office;
import ac.cr.una.proyecto.java.model.Patient;
import ac.cr.una.proyecto.java.service.AppointmentService;

/**
 *
 * @author Yeni
 */
public class AppointmentController implements ActionListener {

    private JTextField namePatient;
    private JComboBox name;
    private JDateChooser fecha;
    private JComboBox hora;
    private JButton accept_button;
    private JButton clean_button;

    private DateFormat dt = DateFormat.getDateInstance();

    private AppointmentService appointmentService;
    private Object[][] appointments;

    /**
     *
     * @param namePatient
     * @param name
     * @param fecha
     * @param hora
     * @param accept_button
     * @param clean_button
     * @throws JsonMappingException
     * @throws IOException
     */
    public AppointmentController(JTextField namePatient, JComboBox name, JDateChooser fecha,
            JComboBox hora, JButton accept_button, JButton clean_button)
            throws JsonMappingException, IOException, Exception {
        super();
        
        
        this.namePatient = namePatient;
        this.name = name;
        this.fecha = fecha;
        this.hora = hora;
        this.accept_button = accept_button;
        this.clean_button = clean_button;

        appointmentService = new AppointmentService();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == accept_button) {
            try {
                updateAppointmentList();
            } catch (IOException ex) {
                Logger.getLogger(AppointmentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(AppointmentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == clean_button) {
            try {
                cleanAll();
            } catch (IOException ex) {
                Logger.getLogger(AppointmentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void updateAppointmentList() throws IOException {
        String dia = Integer.toString(fecha.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(fecha.getCalendar().get(Calendar.MONTH) + 1);
        String year = Integer.toString(fecha.getCalendar().get(Calendar.YEAR));
        String fecha = (dia + "-" + mes + "-" + year);
        
        String namePatientTyped = namePatient.getText();
        String officeTyped = (String) name.getSelectedItem();
        String dateTyped = fecha;
        String hourTyped = hora.getSelectedItem().toString();

        Appointment appointment = new Appointment();
        Patient patient = new Patient(1, "Carlos", "1234", "Carlos Guzman", "22795122", "Cartago",
                "19-11-1993", "Cabeza, panel", "Adicto muy Adicto");
        Office office = new Office(1, "Hospital CIMA", "22795122", "Lunes y Martes", "8:00", "5:00");
        
        appointment.setPatient(patient);
        appointment.setOffice(office);
        appointment.setDate(dateTyped);
        appointment.setHour(hourTyped);

        appointmentService.createAppointment(appointment);
        
        JOptionPane.showMessageDialog(null, "Se agrego " + namePatientTyped + " correctamente");
    }

    private void cleanAll() throws IOException {
        namePatient.setText(" ");
        name.setSelectedItem(" ");
        fecha.setDateFormatString("");
        hora.setSelectedItem(" ");
    }

}
