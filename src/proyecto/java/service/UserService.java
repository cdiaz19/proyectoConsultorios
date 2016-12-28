/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.java.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import proyecto.java.Constants;
import proyecto.java.model.User;

/**
 *
 * @author cristian
 */
public class UserService {
    
    /**
     * Empty Constructor
     */
    public UserService() {
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
        User[] users = loadOfficesFromFile();
        Object[][] data = null;

        if (users != null && users.length > 0) {
            data = new Object[users.length][5]; // filas y columnas
            int i = 0;
            for (User user : users) {
                data[i][0] = checkIfNull(users.getClass().getName());
                data[i][1] = checkIfNull(users.getClass().getName());
                data[i][2] = checkIfNull(users.getClass().getName());
                data[i][3] = checkIfNull(users.getClass().getName());
                data[i][4] = checkIfNull(users.getClass().getName());
                i++;
            }
        }

        return data;
    }

    private User[] loadOfficesFromFile() throws JsonGenerationException,
            JsonMappingException, IOException {
        // Library Jackson parse JSon
        // http://wiki.fasterxml.com/JacksonHome
        User[] offices = null;

        ObjectMapper mapper = new ObjectMapper();
        // Convert JSON string from file to Object
        offices = mapper.readValue(new File(Constants.FILENAME_USER), User[].class);

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
