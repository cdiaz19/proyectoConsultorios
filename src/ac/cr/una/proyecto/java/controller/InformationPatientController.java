/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.proyecto.java.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import ac.cr.una.proyecto.java.Constants;
import static ac.cr.una.proyecto.java.Constants.ACTUAL;
import ac.cr.una.proyecto.java.service.PatientService;

/**
 *
 * @author Kimberly
 */
public class InformationPatientController {

    private DefaultTableModel tableModel;
    private PatientService patientService;
    private Object[][] information;

    /**
     *
     * @param tableModel
     * @throws JsonMappingException
     * @throws IOException
     */
    public InformationPatientController(DefaultTableModel tableModel)
            throws JsonMappingException, IOException {

        this.tableModel = tableModel;
        showInformation();
    }

    /**
     *
     * @throws IOException
     */
    public void showInformation() throws IOException {
        patientService = new PatientService();
        information = patientService.loadPatientObjWrapper();

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
