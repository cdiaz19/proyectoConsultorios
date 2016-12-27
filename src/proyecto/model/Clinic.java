/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.model;

/**
 *
 * @author cristian
 */
public class Clinic extends Office {

    public Clinic() {
    }

    /**
     * @param name
     * @param phone
     * @param days
     * @param hourStart
     * @param hourEnd
     */
    public Clinic(String name, String phone, String days, String hourStart, String hourEnd) {
        super(name, phone, days, hourStart, hourEnd);
    }

    @Override
    public String toString() {
        return super.toString().concat(", Clinica");
    }
    
}
