/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.proyecto.java.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import ac.cr.una.proyecto.java.Constants;
import ac.cr.una.proyecto.java.model.Office;
import ac.cr.una.proyecto.java.service.OfficeService;

/**
 *
 * @author cristian
 */
public class OfficeController implements ActionListener {

    private JTextField name;
    private JTextField phone_number;
    private JTextField days;
    private JTextField hourStart;
    private JTextField hourEnd;
    private JTextField officeBox;
    private JButton accept_form;
    private JButton clean_button;

    private OfficeService officeService;
    private Object[][] offices;

    /**
     *
     * @param name
     * @param phone_number
     * @param days
     * @param hourStart
     * @param hourEnd
     * @param officeBox
     * @param accept_form
     * @param clean_button
     * @throws JsonMappingException
     * @throws IOException
     */
    public OfficeController(JTextField name, JTextField phone_number,
            JTextField days, JTextField hourStart, JTextField hourEnd,
            JTextField officeBox, JButton accept_form,JButton clean_button) throws JsonMappingException, IOException, Exception {
        super();
        this.name = name;
        this.phone_number = phone_number;
        this.days = days;
        this.hourStart = hourStart;
        this.hourEnd = hourEnd;
        this.officeBox = officeBox;
        this.accept_form = accept_form;
        this.clean_button = clean_button;

//        officeService = new OfficeService();
//        offices = officeService.loadOfficesObjWrapperAdd();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == accept_form) {
        try {
            updateOfficesList();
        } catch (IOException ex) {
            Logger.getLogger(OfficeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else if (e.getSource() == clean_button) {
            try {
                cleanAll();
            } catch (IOException ex) {
                Logger.getLogger(AppointmentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void updateOfficesList() throws IOException {
        ArrayList<Office> officesList = new ArrayList<>();
        String nameTyped = name.getText();
        String phoneTyped = phone_number.getText();
        String daysTyped = days.getText();
        String hourStartTyped = hourStart.getText();
        String hourEndTyped = hourEnd.getText();
        String officesBoxTyped = officeBox.getText();

        for (Object[] obj : offices) {
            Office fullText = new Office(obj[0].toString(), obj[1].toString(), obj[2].toString(), obj[3].toString(), obj[4].toString());
            officesList.add(fullText);
        }

        
            officesList.add(new Office(nameTyped, phoneTyped, daysTyped, hourStartTyped, hourEndTyped));
            JOptionPane.showMessageDialog(null,
                    "Se agrego " + nameTyped + " correctamente");
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(Constants.FILENAME), officesList);
    }
    
    private void cleanAll() throws IOException {
        name.setText(" ");
        phone_number.setText(" ");
        days.setText(" ");
        hourStart.setText(" ");
        hourEnd.setText(" ");
        officeBox.setText(" ");
        
    }
}
