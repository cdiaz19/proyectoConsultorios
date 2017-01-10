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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import proyecto.java.view.AppointmentPatientView;

/**
 *
 * @author cristian
 */
public class PatientPanelController implements ActionListener {

    private JMenuItem exit;
    private JMenuItem information;
    private JMenuItem appointment;
    private JDesktopPane escritorio;

    public PatientPanelController(JMenuItem exit, JDesktopPane escritorio, JMenuItem information,
            JMenuItem appointment) {
        super();
        this.exit = exit;
        this.escritorio = escritorio;
        this.information = information;
        this.appointment = appointment;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == exit) {
            System.exit(0);
        } else if (source == information) {
            System.out.println("Informacion personal");
        } else if (source == appointment) {
            try {
                loadAppointment();
            } catch (IOException ex) {
                Logger.getLogger(PatientPanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
        }
    }
    
    private void loadAppointment() throws JsonMappingException, IOException{
        AppointmentPatientView ventana = new AppointmentPatientView();
        escritorio.add(ventana);
    }
}
