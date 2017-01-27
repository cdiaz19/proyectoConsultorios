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
import ac.cr.una.proyecto.java.model.Office;

/**
 *
 * @author cristian
 */
public class OfficeService {

    /**
     * Empty Constructor
     */
    public OfficeService() {
    }

    /**
     * Wrapper to return the list of offices from the File
     *
     * @return Object[][] data
     * @throws com.fasterxml.jackson.core.JsonGenerationException
     * @throws com.fasterxml.jackson.databind.JsonMappingException
     * @throws java.io.IOException
     */
    public Object[][] loadOfficesObjWrapper() throws JsonGenerationException,
            JsonMappingException, IOException {
        Office[] offices = loadOfficesFromFile();
        Object[][] data = null;

        if (offices != null && offices.length > 0) {
            data = new Object[offices.length][5]; // filas y columnas
            int i = 0;
            for (Office office : offices) {
                data[i][0] = checkIfNull(office.getName());
                data[i][1] = checkIfNull(office.getPhone());
                data[i][2] = checkIfNull(office.getDays());
                data[i][3] = checkIfNull(office.getHourStart());
                data[i][4] = checkIfNull(office.getHourEnd());
                i++;
            }
        }

        return data;
    }

    private Office[] loadOfficesFromFile() throws JsonGenerationException,
            JsonMappingException, IOException {
        // Library Jackson parse JSon
        // http://wiki.fasterxml.com/JacksonHome
        Office[] offices = null;

        ObjectMapper mapper = new ObjectMapper();
        // Convert JSON string from file to Object
        offices = mapper.readValue(new File(Constants.FILENAME), Office[].class);

        return offices;
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
