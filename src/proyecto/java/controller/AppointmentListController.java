/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.java.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto.java.Constants;
import proyecto.java.service.AppointmentService;

/**
 *
 * @author Yeni
 */
public class AppointmentListController implements ActionListener {

    private JTextField searchAppointmentTextField = new JTextField(26);
    private DefaultTableModel tableModel;
    private AppointmentService appointmentService;
    private Object[][] appointment;

    /**
     *
     * @param searchTermTextField
     * @param tableModel
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public AppointmentListController(JTextField searchTermTextField,
            DefaultTableModel tableModel) throws JsonGenerationException,
            JsonMappingException, IOException {

        super();
        appointmentService = new AppointmentService();
        appointment = appointmentService.loadAppointmentsObjWrapper();

        this.searchAppointmentTextField = searchTermTextField;
        this.tableModel = tableModel;

        // Load the table with the list of appointment
        tableModel.setDataVector(appointment, Constants.TABLE_HEADER_APPOINTMENT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String searchTerm = searchAppointmentTextField.getText();

        //Method to search items
        updateTableSearchTerms(searchTerm);
    }

    private void updateTableSearchTerms(String searchTerm) {
        if (searchTerm != null && !"".equals(searchTerm)
                && appointment != null && appointment.length > 1) {
            Object[][] newData = new Object[appointment.length][];
            int idx = 0;
            for (Object[] obj : appointment) {
                String fullText = obj[0].toString() + obj[1].toString()
                        + obj[2].toString() + obj[3].toString();

                if (fullText.contains(searchTerm.trim())) {
                    newData[idx++] = obj;
                }
            }
            tableModel.setDataVector(newData, Constants.TABLE_HEADER_APPOINTMENT);
        } else {
            JOptionPane.showMessageDialog(null,
                    "La busqueda esta vacia", "Error",
                    JOptionPane.ERROR_MESSAGE);
            tableModel.setDataVector(appointment, Constants.TABLE_HEADER_APPOINTMENT);
        }
    }

}
