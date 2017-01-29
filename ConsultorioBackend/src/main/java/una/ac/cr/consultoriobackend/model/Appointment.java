/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ac.cr.consultoriobackend.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "appointment", catalog = "proyectoConsultorio", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id_appointment")})
public class Appointment implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_appointment", unique = true, nullable = false)
    private int idAppointment;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_office", nullable = false)
    private Office office;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_patient", nullable = false)
    private Patient patient;

    @Column(name = "date", unique = false, nullable = false)
    private String date;

    @Column(name = "hour", unique = false, nullable = false)
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
    public Appointment(int idAppointment, Office office, Patient patient,
            String date, String hour) {
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
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.idAppointment;
        hash = 79 * hash + Objects.hashCode(this.office);
        hash = 79 * hash + Objects.hashCode(this.patient);
        hash = 79 * hash + Objects.hashCode(this.date);
        hash = 79 * hash + Objects.hashCode(this.hour);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Appointment other = (Appointment) obj;
        if (this.idAppointment != other.idAppointment) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.hour, other.hour)) {
            return false;
        }
        if (!Objects.equals(this.office, other.office)) {
            return false;
        }
        if (!Objects.equals(this.patient, other.patient)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PatientAppointment{" + "idAppointment=" + idAppointment + ", office=" + office + ", patient=" + patient + ", date=" + date + ", hour=" + hour + '}';
    }

    
}
