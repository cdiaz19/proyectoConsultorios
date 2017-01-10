/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.java.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto.java.Constants;
import proyecto.java.service.PatientService;

/**
 *
 * @author Kimberly
 */
public class InformationPatientController implements ActionListener{
    private JButton verify;
    private DefaultTableModel tableModel;
    private PatientService patientService;
    private Object[][] information;

    public InformationPatientController(JButton verify, DefaultTableModel tableModel) 
            throws JsonMappingException, IOException {
        this.verify = verify;
        this.tableModel = tableModel;
        
        patientService = new PatientService();
        information = patientService.loadOfficesObjWrapper();
        this.tableModel = tableModel;
        
        tableModel.setDataVector(information, Constants.TABLE_HEADER_APPOINTMENT);
    }
    
    public void actionPerformed(ActionEvent e) {
        showInformation();
    }

       public void showInformation(){
        LoginController log = new LoginController();
        String user = log.returnName();
        if (user != null && !"".equals(user)
                && information != null && information.length > 1) {
            System.out.println("guillermo");
            Object[][] newData = new Object[information.length][];
            int idx = 0;
            for (Object[] obj : information) {
                String fullText = obj[0].toString() + obj[1].toString()
                        + obj[2].toString() + obj[3].toString();

                if (fullText.contains(user.trim())) {
                    newData[idx++] = obj;
                }
            }
            tableModel.setDataVector(newData, Constants.TABLE_HEADER_APPOINTMENT);
        }
    }
    
}
