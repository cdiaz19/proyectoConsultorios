/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.proyecto.java.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Yeni
 */
public class Appointment {
    @JsonProperty("idAppointment")
    private int idAppointment;
    @JsonProperty("office")
    private Office office;
    @JsonProperty("patient")
    private Patient patient;
    @JsonProperty("date")
    private String date;
    @JsonProperty("hour")
    private String hour;

    /**
     * 
     */
    public Appointment() {
    }

    /**
     * 
     * @param idAppointment
     * @param office
     * @param patient
     * @param date
     * @param hour 
     */
    public Appointment(int idAppointment, Office office, Patient patient, String date, String hour) {
        this.idAppointment = idAppointment;
        this.office = office;
        this.patient = patient;
        this.date = date;
        this.hour = hour;
    }

    /**
     * @return the idAppointment
     */
    public int getIdAppointment() {
        return idAppointment;
    }

    /**
     * @param idAppointment the idAppointment to set
     */
    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    /**
     * @return the office
     */
    public Office getOffice() {
        return office;
    }

    /**
     * @param office the office to set
     */
    public void setOffice(Office office) {
        this.office = office;
    }

    /**
     * @return the patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * @param patient the patient to set
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the hour
     */
    public String getHour() {
        return hour;
    }

    /**
     * @param hour the hour to set
     */
    public void setHour(String hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Appointment{" + "idAppointment=" + idAppointment + 
                ", office=" + office + 
                ", patient=" + patient + 
                ", date=" + date + 
                ", hour=" + hour + '}';
    }
}
