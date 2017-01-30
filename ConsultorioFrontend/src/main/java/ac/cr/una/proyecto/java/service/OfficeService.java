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
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;

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
            JsonMappingException, IOException, Exception {
        Office[] offices = loadJsonFromWebService();
        
        Object[][] data = null;

        if (offices != null && offices.length > 0) {
            data = new Object[offices.length][6]; // filas y columnas
            int i = 0;
            for (Office office : offices) {
                data[i][0] = checkIfNull(office.getIdOffice());
                data[i][1] = checkIfNull(office.getName());
                data[i][2] = checkIfNull(office.getPhone());
                data[i][3] = checkIfNull(office.getDays());
                data[i][4] = checkIfNull(office.getHourStart());
                data[i][5] = checkIfNull(office.getHourEnd());
                i++;
            }
        }

        return data;
    }
    
     public Object[][] loadOfficesObjWrapperAdd() throws JsonGenerationException,
            JsonMappingException, IOException, Exception {
        Office[] offices = loadOfficesFromFile();
        
        Object[][] data = null;

        if (offices != null && offices.length > 0) {
            data = new Object[offices.length][6]; // filas y columnas
            int i = 0;
            for (Office office : offices) {
                data[i][0] = checkIfNull(office.getIdOffice());
                data[i][1] = checkIfNull(office.getName());
                data[i][2] = checkIfNull(office.getPhone());
                data[i][3] = checkIfNull(office.getDays());
                data[i][4] = checkIfNull(office.getHourStart());
                data[i][5] = checkIfNull(office.getHourEnd());
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
    
    private Office[] loadJsonFromWebService() throws Exception {
        Office[] office;
        String jSonFile;
        ObjectMapper mapper = new ObjectMapper();

        Client client = Client.create();

        WebResource webResource = client
                .resource(Constants.WS_URL_OFFICE);

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        jSonFile = response.getEntity(String.class);

        office = mapper.readValue(jSonFile, Office[].class);

        return office;
    }
    
    public boolean createOffice(Office office) throws JsonGenerationException,
            JsonMappingException, IOException {

        boolean isCreated = true;
        ObjectMapper mapper = new ObjectMapper();

        Client client = Client.create();

        WebResource webResource = client
                .resource(Constants.WS_URL_OFFICE);

        String jsonInString = mapper.writeValueAsString(office);

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

    public boolean deleteOffice(int id) {
        boolean isDeleted = false;

        Client client = Client.create();

        WebResource webResource = client
                .resource(Constants.WS_URL_OFFICE.concat("/").concat(String.valueOf(id)));

        //POST del JSON
        ClientResponse response = webResource.delete(ClientResponse.class);

        if (response.getStatus() != 200) {
            isDeleted = false;
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        return isDeleted;
    }
    
    public boolean updateOffice(Office office) throws JsonGenerationException,
            JsonMappingException, IOException {

        boolean isCreated = true;
        ObjectMapper mapper = new ObjectMapper();

        Client client = Client.create();

        WebResource webResource = client
                .resource(Constants.WS_URL_OFFICE);

        String jsonInString = mapper.writeValueAsString(office);

        //PUT del JSON
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON_TYPE)
                .put(ClientResponse.class, jsonInString);

        if (response.getStatus() != 200) {
            isCreated = false;
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        return isCreated;
    }
}
