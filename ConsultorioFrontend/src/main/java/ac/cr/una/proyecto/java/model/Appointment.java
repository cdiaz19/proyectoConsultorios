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
    @JsonProperty("id_appointment")
    private int idAppointment;
    @JsonProperty("namePatient")
    private String namePatient;
    @JsonProperty("name")
    private String name;
    @JsonProperty("fecha")
    private String fecha;
    @JsonProperty("hora")
    private String hora;

    /**
     *
     * @param id_appointment
     * @param namePatient
     * @param name
     * @param fecha
     * @param hora
     */
    public Appointment(int id_appointment,String namePatient, String name, String fecha, String hora) {
        this.idAppointment = idAppointment;
        this.namePatient = namePatient;
        this.name = name;
        this.fecha = fecha;
        this.hora = hora;
    }

    /**
     *
     */
    public Appointment() {
    }

    public Appointment(String namePatient, String name, String fecha, String hora) {
        this.namePatient = namePatient;
        this.name = name;
        this.fecha = fecha;
        this.hora = hora;
    }
    

    /**
     *
     * @return
     */
    public int getIdAppointment() {
        return idAppointment;
    }

    /**
     *
     * @param idAppointment
     */
    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }
    
    /**
     *
     * @return
     */
    public String getNamePatient() {
        return namePatient;
    }

    /**
     *
     * @param namePatient
     */
    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @return
     */
    public String getHora() {
        return hora;
    }

    /**
     *
     * @param hora
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Appointment{" + "idAppointment=" + idAppointment + ", namePatient=" + namePatient + ", name=" + name + ", fecha=" + fecha + ", hora=" + hora + '}';
    }

  

}
