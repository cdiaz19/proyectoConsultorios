/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.java.controller;

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
import proyecto.java.Constants;
import proyecto.java.model.Clinic;
import proyecto.java.model.Office;
import proyecto.java.service.OfficeService;

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
    private JComboBox officeBox;
    private JButton accept_form;

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
     * @throws JsonMappingException
     * @throws IOException
     */
    public OfficeController(JTextField name, JTextField phone_number,
            JTextField days, JTextField hourStart, JTextField hourEnd,
            JComboBox officeBox, JButton accept_form) throws JsonMappingException, IOException {
        super();
        this.name = name;
        this.phone_number = phone_number;
        this.days = days;
        this.hourStart = hourStart;
        this.hourEnd = hourEnd;
        this.officeBox = officeBox;
        this.accept_form = accept_form;

        officeService = new OfficeService();
        offices = officeService.loadOfficesObjWrapper();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            updateOfficesList();
        } catch (IOException ex) {
            Logger.getLogger(OfficeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void updateOfficesList() throws IOException {
        ArrayList<Office> officesList = new ArrayList<>();
        String nameTyped = name.getText().toString();
        String phoneTyped = phone_number.getText().toString();
        String daysTyped = days.getText().toString();
        String hourStartTyped = hourStart.getText().toString();
        String hourEndTyped = hourEnd.getText().toString();
        String officesBoxTyped = officeBox.getSelectedItem().toString();

        for (Object[] obj : offices) {
            Office fullText = new Office(obj[0].toString(), obj[1].toString(), obj[2].toString(), obj[3].toString(), obj[4].toString());
            officesList.add(fullText);
        }

        if (officesBoxTyped.equals("Hospital")) {
            officesList.add(new Clinic(nameTyped, phoneTyped, daysTyped, hourStartTyped, hourEndTyped));
            JOptionPane.showMessageDialog(null,
                    "Se agregó " + nameTyped + " correctamente");
        } else {
            officesList.add(new Clinic(nameTyped, phoneTyped, daysTyped, hourStartTyped, hourEndTyped));
            JOptionPane.showMessageDialog(null,
                    "Se agregó " + nameTyped + " correctamente");
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(Constants.FILENAME), officesList);
    }  
}
