/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ac.cr.consultoriobackend.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "patient", catalog = "proyectoConsultorio", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id_patient")})
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_patient", unique = true, nullable = false)
    private int idPatient;
    @Column(name = "user", unique = false, nullable = false)
    private String user;
    @Column(name = "password", unique = false, nullable = false)
    private String password;
    @Column(name = "name", unique = false, nullable = false)
    private String name;
    @Column(name = "phone", unique = false, nullable = false)
    private String phone;
    @Column(name = "address", unique = false, nullable = false)
    private String address;
    @Column(name = "birthday", unique = false, nullable = false)
    private String birthday;
    @Column(name = "associatedDiseases", unique = false, nullable = false)
    private String associatedDiseases;
    @Column(name = "observation", unique = false, nullable = false)
    private String observation;

    /**
     *
     */
    public Patient() {
    }

    /**
     *
     * @param idPatient
     * @param user
     * @param password
     * @param name
     * @param phone
     * @param address
     * @param birthday
     * @param associatedDiseases
     * @param observation
     */
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.idPatient;
        hash = 67 * hash + Objects.hashCode(this.user);
        hash = 67 * hash + Objects.hashCode(this.password);
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.phone);
        hash = 67 * hash + Objects.hashCode(this.address);
        hash = 67 * hash + Objects.hashCode(this.birthday);
        hash = 67 * hash + Objects.hashCode(this.associatedDiseases);
        hash = 67 * hash + Objects.hashCode(this.observation);
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
        final Patient other = (Patient) obj;
        if (this.idPatient != other.idPatient) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.birthday, other.birthday)) {
            return false;
        }
        if (!Objects.equals(this.associatedDiseases, other.associatedDiseases)) {
            return false;
        }
        if (!Objects.equals(this.observation, other.observation)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Patient{" + "idPatient=" + idPatient
                + ", user=" + user
                + ", password=" + password
                + ", name=" + name
                + ", phone=" + phone
                + ", address=" + address
                + ", birthday=" + birthday
                + ", associatedDiseases=" + associatedDiseases
                + ", observation=" + observation + '}';
    }
}
