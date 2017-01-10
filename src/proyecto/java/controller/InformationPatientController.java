/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.java.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto.java.Constants;
import static proyecto.java.Constants.ACTUAL;
import proyecto.java.model.Patient;
import proyecto.java.service.PatientService;

/**
 *
 * @author Kimberly
 */
public class InformationPatientController {

    private DefaultTableModel tableModel;
    private PatientService patientService;
    private Object[][] information;

    public InformationPatientController(DefaultTableModel tableModel)
            throws JsonMappingException, IOException {

        this.tableModel = tableModel;
        showInformation();
    }

    public void showInformation() throws IOException {
        patientService = new PatientService();
        information = patientService.loadOfficesObjWrapper();
        LoginController log = new LoginController();

        String user = ACTUAL;

        if (user != null && !"".equals(user)
                && information != null && information.length > 1) {
            Object[][] newData = new Object[information.length][];
            int idx = 0;
            for (Object[] obj : information) {
                String fullText = obj[0].toString() + obj[1].toString()
                        + obj[2].toString() + obj[3].toString();

                if (fullText.contains(user.trim())) {
                    newData[idx++] = obj;
                }
            }
            tableModel.setDataVector(newData, Constants.TABLE_HEADER_PATIENT);
        }
    }

}
