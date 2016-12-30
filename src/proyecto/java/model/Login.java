/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.java.model;


/**
 *
 * @author Kimberly
 */
public class Login {
    
    private String userName;
    private String password;

    
    public Login() {
    }

    /**
     *
     * @param userName
     * @param password
     */
    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" + "userName=" + userName + ", password=" + password + '}';
    }
    
    
}
