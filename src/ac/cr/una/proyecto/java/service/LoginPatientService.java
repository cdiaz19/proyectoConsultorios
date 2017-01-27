/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.proyecto.java.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import ac.cr.una.proyecto.java.Constants;
import ac.cr.una.proyecto.java.model.Patient;

/**
 *
 * @author Kimberly
 */
public class LoginPatientService {

    /**
     *
     * @return
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public Object[][] loadOfficesObjWrapper() throws JsonGenerationException,
            JsonMappingException, IOException {
        Patient[] patients = loadOfficesFromFile();
        Object[][] data = null;

        if (patients != null && patients.length > 0) {
            data = new Object[patients.length][2]; // filas y columnas
            int i = 0;
            for (Patient patient : patients) {
                data[i][0] = checkIfNull(patient.getUser());
                data[i][1] = checkIfNull(patient.getPassword());

                i++;
            }
        }

        return data;
    }

    private Patient[] loadOfficesFromFile() throws JsonGenerationException,
            JsonMappingException, IOException {
        // Library Jackson parse JSon
        // http://wiki.fasterxml.com/JacksonHome
        Patient[] patients = null;

        ObjectMapper mapper = new ObjectMapper();
        // Convert JSON string from file to Object
        patients = mapper.readValue(new File(Constants.FILENAME_PATIENT), Patient[].class);

        return patients;
    }

    private String checkIfNull(Object obj) {
        String text;
        if (obj == null) {
            text = "";
        } else {
            text = obj.toString();
        }
        return text;
    }

}
