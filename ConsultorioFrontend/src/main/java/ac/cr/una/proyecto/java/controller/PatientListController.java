/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.proyecto.java.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import ac.cr.una.proyecto.java.Constants;
import ac.cr.una.proyecto.java.service.PatientService;

/**
 *
 * @author cristian
 */
public class PatientListController implements ActionListener {

    private JTextField searchOfficeTextField = new JTextField(26);
    private DefaultTableModel tableModel;
    private PatientService patientService;
    private Object[][] patients;

    /**
     * Main Constructor
     *
     * @param searchTermTextField
     * @param tableModel
     *
     * @throws com.fasterxml.jackson.core.JsonGenerationException
     * @throws com.fasterxml.jackson.databind.JsonMappingException
     * @throws java.io.IOException
     */
    public PatientListController(JTextField searchTermTextField,
            DefaultTableModel tableModel) throws JsonGenerationException,
            JsonMappingException, IOException, Exception {
        super();
        patientService = new PatientService();
        patients = patientService.loadPatientObjWrapper();

        this.searchOfficeTextField = searchTermTextField;
        this.tableModel = tableModel;

        // Load the table with the list of patients
        tableModel.setDataVector(patients, Constants.TABLE_HEADER_PATIENT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String searchTerm = searchOfficeTextField.getText();

        //Method to search items
        updateTableSearchTerms(searchTerm);
    }

    private void updateTableSearchTerms(String searchTerm) {
        if (searchTerm != null && !"".equals(searchTerm)
                && patients != null && patients.length > 1) {
            Object[][] newData = new Object[patients.length][];
            int idx = 0;
            for (Object[] obj : patients) {
                String fullText = obj[0].toString() + obj[1].toString()
                        + obj[2].toString() + obj[3].toString();

                if (fullText.contains(searchTerm.trim())) {
                    newData[idx++] = obj;
                }
            }
            tableModel.setDataVector(newData, Constants.TABLE_HEADER_PATIENT);
        } else {
            JOptionPane.showMessageDialog(null,
                    "La busqueda esta vacia", "Error",
                    JOptionPane.ERROR_MESSAGE);
            tableModel.setDataVector(patients, Constants.TABLE_HEADER_PATIENT);
        }
    }
}
