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
import proyecto.java.model.Appointment;

/**
 *
 * @author Yeni
 */
public class AppointmentService {

    /**
     *
     */
    public AppointmentService() {
    }

    /**
     * Wrapper to return the list of appointments from the File
     *
     * @return Object[][] data
     * @throws com.fasterxml.jackson.core.JsonGenerationException
     * @throws com.fasterxml.jackson.databind.JsonMappingException
     * @throws java.io.IOException
     */
    public Object[][] loadAppointmentsObjWrapper() throws JsonGenerationException,
            JsonMappingException, IOException {
        Appointment[] appointments = loadAppointmentsFromFile();
        Object[][] data = null;

        if (appointments != null && appointments.length > 0) {
            data = new Object[appointments.length][4]; // filas y columnas
            int i = 0;
            for (Appointment appointment : appointments) {
                data[i][0] = checkIfNull(appointment.getNamePatient());
                data[i][1] = checkIfNull(appointment.getName());
                data[i][2] = checkIfNull(appointment.getFecha());
                data[i][3] = checkIfNull(appointment.getHora());
                i++;
            }
        }
        return data;
    }

    private Appointment[] loadAppointmentsFromFile() throws JsonGenerationException,
            JsonMappingException, IOException {
        // Library Jackson parse JSon
        // http://wiki.fasterxml.com/JacksonHome
        Appointment[] appointment = null;
        ObjectMapper mapper = new ObjectMapper();
        // Convert JSON string from file to Object
        appointment = mapper.readValue(new File(Constants.FILENAME_APPOINTMENT), Appointment[].class);

        return appointment;
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
