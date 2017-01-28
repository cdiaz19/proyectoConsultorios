/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.proyecto.java.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import ac.cr.una.proyecto.java.view.AppointmentPatientView;
import ac.cr.una.proyecto.java.view.InformationPatientView;

/**
 *
 * @author cristian
 */
public class PatientPanelController implements ActionListener {

    private JMenuItem exit;
    private JMenuItem information;
    private JMenuItem appointment;
    private JDesktopPane escritorio;

    /**
     *
     * @param exit
     * @param escritorio
     * @param information
     * @param appointment
     */
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
            try {
                loadInformation();
            } catch (IOException ex) {
                Logger.getLogger(PatientPanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (source == appointment) {
            try {
                loadAppointment();
            } catch (Exception ex) {
                Logger.getLogger(PatientPanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
        }
    }

    private void loadAppointment() throws JsonMappingException, IOException, Exception {
        AppointmentPatientView ventana = new AppointmentPatientView();
        escritorio.add(ventana);
    }

    private void loadInformation() throws JsonMappingException, IOException {
        InformationPatientView ventana = new InformationPatientView();
        escritorio.add(ventana);
    }
}
