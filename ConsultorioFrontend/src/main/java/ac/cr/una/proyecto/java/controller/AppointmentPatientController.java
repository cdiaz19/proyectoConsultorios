/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.proyecto.java.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ac.cr.una.proyecto.java.Constants;
import static ac.cr.una.proyecto.java.Constants.ACTUAL;
import ac.cr.una.proyecto.java.service.AppointmentService;

/**
 *
 * @author Yeni
 */
public class AppointmentPatientController {

    private DefaultTableModel tableModel;
    private AppointmentService appointmentService;
    private Object[][] appointment;

    public AppointmentPatientController(DefaultTableModel tableModel)
            throws JsonMappingException, IOException, Exception {
        super();
        this.tableModel = tableModel;
        verifyDate();
    }

    public void verifyDate() throws JsonMappingException, IOException, Exception {
        appointmentService = new AppointmentService();
        appointment = appointmentService.loadAppointmentsObjWrapper();

        String user = ACTUAL;
        if (user != null && !"".equals(user)
                && appointment != null && appointment.length > 1) {
            Object[][] newData = new Object[appointment.length][];
            int idx = 0;
            for (Object[] obj : appointment) {
                String fullText = obj[0].toString() + obj[1].toString()
                        + obj[2].toString() + obj[3].toString();

                if (fullText.contains(user.trim())) {
                    newData[idx++] = obj;
                }
            }
            tableModel.setDataVector(newData, Constants.TABLE_HEADER_APPOINTMENT);
        } else {
            JOptionPane.showMessageDialog(null,
                    "NO tiene citas pendientes", "Error",
                    JOptionPane.ERROR_MESSAGE);
            tableModel.setDataVector(appointment, Constants.TABLE_HEADER_APPOINTMENT);
        }
    }
}
