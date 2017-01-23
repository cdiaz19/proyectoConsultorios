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
@Table(name = "office", catalog = "proyectoConsultorio", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id_office")})
public class Office implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_office", unique = true, nullable = false)
    private int idOffice;
    @Column(name = "name", unique = false, nullable = false)
    private String name;
    @Column(name = "phone", unique = false, nullable = false)
    private String phone;
    @Column(name = "days", unique = false, nullable = false)
    private String days;
    @Column(name = "hourStart", unique = false, nullable = false)
    private String hourStart;
    @Column(name = "hourEnd", unique = false, nullable = false)
    private String hourEnd;

    /**
     *
     */
    public Office() {
    }

    /**
     *
     * @param idOffice
     * @param name
     * @param phone
     * @param days
     * @param hourStart
     * @param hourEnd
     */
    public Office(int idOffice, String name, String phone, String days, String hourStart, 
            String hourEnd) {
        this.idOffice = idOffice;
        this.name = name;
        this.phone = phone;
        this.days = days;
        this.hourStart = hourStart;
        this.hourEnd = hourEnd;
    }

    /**
     * @return the idOffice
     */
    public int getIdOffice() {
        return idOffice;
    }

    /**
     * @param idOffice the idOffice to set
     */
    public void setIdOffice(int idOffice) {
        this.idOffice = idOffice;
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
     * @return the days
     */
    public String getDays() {
        return days;
    }

    /**
     * @param days the days to set
     */
    public void setDays(String days) {
        this.days = days;
    }

    /**
     * @return the hourStart
     */
    public String getHourStart() {
        return hourStart;
    }

    /**
     * @param hourStart the hourStart to set
     */
    public void setHourStart(String hourStart) {
        this.hourStart = hourStart;
    }

    /**
     * @return the hourEnd
     */
    public String getHourEnd() {
        return hourEnd;
    }

    /**
     * @param hourEnd the hourEnd to set
     */
    public void setHourEnd(String hourEnd) {
        this.hourEnd = hourEnd;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.idOffice;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.phone);
        hash = 79 * hash + Objects.hashCode(this.days);
        hash = 79 * hash + Objects.hashCode(this.hourStart);
        hash = 79 * hash + Objects.hashCode(this.hourEnd);
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
        final Office other = (Office) obj;
        if (this.idOffice != other.idOffice) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.days, other.days)) {
            return false;
        }
        if (!Objects.equals(this.hourStart, other.hourStart)) {
            return false;
        }
        if (!Objects.equals(this.hourEnd, other.hourEnd)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Office{" + "idOffice=" + idOffice
                + ", name=" + name
                + ", phone=" + phone
                + ", days=" + days
                + ", hourStart=" + hourStart
                + ", hourEnd=" + hourEnd + '}';
    }
}
