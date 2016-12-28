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
public class User {
    
    @JsonProperty("username")
    protected String username;
    @JsonProperty("password")
    protected String password;

    /**
     * @param username
     * @param password
     */
    public User(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
