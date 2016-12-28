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
public class Office {
    
    @JsonProperty("name")
    private String name;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("days")
    private String days;
    @JsonProperty("hourStart")
    private String hourStart;
    @JsonProperty("hourEnd")
    private String hourEnd;

    public Office() {
    }

    public Office(String name, String phone, String days, String hourStart, String hourEnd) {
        this.name = name;
        this.phone = phone;
        this.days = days;
        this.hourStart = hourStart;
        this.hourEnd = hourEnd;
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
    public String toString() {
        return "Office{" + "name=" + name + ", phone=" + phone + ", days=" + days + ", hourStart=" + hourStart + ", hourEnd=" + hourEnd + '}';
    }
    
}
