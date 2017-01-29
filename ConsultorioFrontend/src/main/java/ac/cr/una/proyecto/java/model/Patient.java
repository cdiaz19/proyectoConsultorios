/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.proyecto.java.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author cristian
 */
public class Patient {

    @JsonProperty("idPatient")
    private int idPatient;
    @JsonProperty("user")
    private String user;
    @JsonProperty("password")
    private String password;
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

    public Patient(int idPatient, String user, String password, String name, String phone, String address, String birthday, String associatedDiseases, String observation) {
        this.idPatient = idPatient;
        this.user = user;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.associatedDiseases = associatedDiseases;
        this.observation = observation;
    }

    /**
     * @return the idPatient
     */
    public int getIdPatient() {
        return idPatient;
    }

    /**
     * @param idPatient the idPatient to set
     */
    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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
}
