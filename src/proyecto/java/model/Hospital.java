/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.java.model;

/**
 *
 * @author cristian
 */
public class Hospital extends Office {

    /**
     *
     */
    public Hospital() {
    }

    /**
     * @param name
     * @param phone
     * @param days
     * @param hourStart
     * @param hourEnd
     */
    public Hospital(String name, String phone, String days, String hourStart, String hourEnd) {
        super(name, phone, days, hourStart, hourEnd);
    }

    @Override
    public String toString() {
        return super.toString().concat(", Hospital");
    }

}
