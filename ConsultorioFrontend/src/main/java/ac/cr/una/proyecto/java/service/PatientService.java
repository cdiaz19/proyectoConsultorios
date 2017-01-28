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
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author cristian
 */
public class PatientService {
    
    /**
     * Empty Constructor
     */
    public PatientService() {
    }

    /**
     * Wrapper to return the list of patients from the File
     *
     * @return Object[][] data
     * @throws com.fasterxml.jackson.core.JsonGenerationException
     * @throws com.fasterxml.jackson.databind.JsonMappingException
     * @throws java.io.IOException
     */
    public Object[][] loadPatientObjWrapper() throws JsonGenerationException,
            JsonMappingException, IOException, Exception {
        Patient[] patients = loadJsonFromWebService();
        Object[][] data = null;

        if (patients != null && patients.length > 0) {
            data = new Object[patients.length][8]; // filas y columnas
            int i = 0;
            for (Patient patient : patients) {
                data[i][0] = checkIfNull(patient.getUser());
                data[i][1] = checkIfNull(patient.getPassword());
                data[i][2] = checkIfNull(patient.getName());
                data[i][3] = checkIfNull(patient.getPhone());
                data[i][4] = checkIfNull(patient.getAddress());
                data[i][5] = checkIfNull(patient.getBirthday());
                data[i][6] = checkIfNull(patient.getAssociatedDiseases());
                data[i][7] = checkIfNull(patient.getObservation());
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
    
    private Patient[] loadJsonFromWebService() throws Exception {
        Patient[] patient;
        String jSonFile;
        ObjectMapper mapper = new ObjectMapper();

        Client client = Client.create();

        WebResource webResource = client
                .resource(Constants.WS_URL_PATIENT);

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        jSonFile = response.getEntity(String.class);

        patient = mapper.readValue(jSonFile, Patient[].class);

        return patient;
    }

    
    public boolean createPatient(Patient patient) throws JsonGenerationException,
            JsonMappingException, IOException {

        boolean isCreated = true;
        ObjectMapper mapper = new ObjectMapper();

        Client client = Client.create();

        WebResource webResource = client
                .resource(Constants.WS_URL_PATIENT);

        String jsonInString = mapper.writeValueAsString(patient);

        //POST del JSON
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON_TYPE)
                .post(ClientResponse.class, jsonInString);

        if (response.getStatus() != 200) {
            isCreated = false;
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        return isCreated;
    }

    public boolean deletePatient(int id) {
        boolean isDeleted = false;

        Client client = Client.create();

        WebResource webResource = client
                .resource(Constants.WS_URL_PATIENT.concat("/").concat(String.valueOf(id)));

        //POST del JSON
        ClientResponse response = webResource.delete(ClientResponse.class);

        if (response.getStatus() != 200) {
            isDeleted = false;
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        return isDeleted;
    }
}
