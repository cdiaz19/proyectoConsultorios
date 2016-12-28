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
public class Doctor extends User {

    private String name;

    /**
     * @param username
     * @param password
     * @param name
     */
    public Doctor(String username, String password, String name) {
        super(username, password);
        this.setName(name);
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString().concat(", Doctor{" +
                "name='" + name + '\'' +
                '}');
    } 
}
