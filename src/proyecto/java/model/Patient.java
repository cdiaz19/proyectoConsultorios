/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.java.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author cristian
 */
public class Patient {

    @JsonProperty("name")
    private String name;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("address")
    private String address;
    @JsonProperty("birthday")
    private String birthday;
    @JsonProperty("associatedDiseases")
    private String associatedDiseases;
    @JsonProperty("observation")
    private String observation;

    public Patient() {
    }
    
    /**
     * @param name
     * @param phone
     * @param address
     * @param birthday
     * @param associatedDiseases
     * @param observation 
     */
    public Patient(String name, String phone, String address, String birthday,
            String associatedDiseases, String observation) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.associatedDiseases = associatedDiseases;
        this.observation = observation;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the associatedDiseases
     */
    public String getAssociatedDiseases() {
        return associatedDiseases;
    }

    /**
     * @param associatedDiseases the associatedDiseases to set
     */
    public void setAssociatedDiseases(String associatedDiseases) {
        this.associatedDiseases = associatedDiseases;
    }

    /**
     * @return the observation
     */
    public String getObservation() {
        return observation;
    }

    /**
     * @param observation the observation to set
     */
    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Override
    public String toString() {
        return "Patient{" + "name=" + name
                + ", phone=" + phone
                + ", address=" + address
                + ", birthday=" + birthday
                + ", associatedDiseases=" + associatedDiseases
                + ", observation=" + observation + '}';
    }
}
