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
import ac.cr.una.proyecto.java.view.AddAppointmentView;
import ac.cr.una.proyecto.java.view.AddOfficeView;
import ac.cr.una.proyecto.java.view.AddPatientView;
import ac.cr.una.proyecto.java.view.AppointmentListView;
import ac.cr.una.proyecto.java.view.OfficesListView;
import ac.cr.una.proyecto.java.view.PatientListView;
import ac.cr.una.proyecto.java.view.PrincipalPanelView;

/**
 *
 * @author cristian
 */
public class PrincipalPanelController implements ActionListener {

    private JMenuItem exit;
    private JMenuItem addOffice;
    private JMenuItem allOffice;
    private JDesktopPane escritorio;
    private JMenuItem allPatient;
    private JMenuItem addPatient;
    private JMenuItem allAppointment;
    private JMenuItem addAppointment;

    /**
     *
     * @param exit
     * @param addOffice
     * @param allOffice
     * @param escritorio
     * @param allPatient
     * @param addPatient
     * @param allAppointment
     * @param addAppointment
     */
    public PrincipalPanelController(JMenuItem exit, JMenuItem addOffice, JMenuItem allOffice,
            JDesktopPane escritorio, JMenuItem allPatient, JMenuItem addPatient,
            JMenuItem allAppointment, JMenuItem addAppointment) {
        super();
        this.exit = exit;
        this.addOffice = addOffice;
        this.allOffice = allOffice;
        this.escritorio = escritorio;
        this.allPatient = allPatient;
        this.addPatient = addPatient;
        this.allAppointment = allAppointment;
        this.addAppointment = addAppointment;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == addOffice) {
            try {
                loadAddOfficeForm(e);
            } catch (Exception ex) {
                Logger.getLogger(PrincipalPanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (source == addPatient) {
            try {
                loadAddPatientForm(e);
            } catch (IOException ex) {
                ex.getMessage();
                Logger.getLogger(PrincipalPanelView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (source == allOffice) {
            try {
                loadListOffices(e);
            } catch (Exception ex) {
                Logger.getLogger(PrincipalPanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (source == allPatient) {
            try {
                loadListPatients(e);
            } catch (IOException ex) {
                Logger.getLogger(PrincipalPanelController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(PrincipalPanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (source == addAppointment) {
            try {
                loadListAppointments(e);
            } catch (IOException ex) {
                Logger.getLogger(PrincipalPanelController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(PrincipalPanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (source == allAppointment) {
            try {
                loadAddAppointmentForm(e);
            } catch (IOException ex) {
                Logger.getLogger(PrincipalPanelView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(PrincipalPanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (source == exit) {
            System.exit(0);
        }
    }

    private void loadAddOfficeForm(java.awt.event.ActionEvent evt) throws IOException, Exception {
        AddOfficeView ventanaInterna = new AddOfficeView();
        escritorio.add(ventanaInterna);
    }

    private void loadAddPatientForm(java.awt.event.ActionEvent evt) throws IOException {
        AddPatientView ventanaInterna = new AddPatientView();
        escritorio.add(ventanaInterna);
    }

    private void loadAddAppointmentForm(java.awt.event.ActionEvent evt) throws IOException, Exception {
        AddAppointmentView ventanaInterna = new AddAppointmentView();
        escritorio.add(ventanaInterna);
    }

    private void loadListOffices(java.awt.event.ActionEvent evt) throws JsonMappingException, IOException, Exception {
        OfficesListView ventanaInterna = new OfficesListView();
        escritorio.add(ventanaInterna);
    }

    private void loadListPatients(java.awt.event.ActionEvent evt) throws JsonMappingException, IOException, Exception {
        PatientListView ventanaInterna = new PatientListView();
        escritorio.add(ventanaInterna);
    }

    private void loadListAppointments(java.awt.event.ActionEvent evt) throws JsonMappingException, IOException, Exception {
        AppointmentListView ventanaInterna = new AppointmentListView();
        escritorio.add(ventanaInterna);
    }
}
