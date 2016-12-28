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
import proyecto.java.view.AddOfficeView;
import proyecto.java.view.AddPatientView;
import proyecto.java.view.OfficesListView;
import proyecto.java.view.PatientListView;
import proyecto.java.view.PrincipalPanelView;

/**
 *
 * @author cristian
 */
public class PrincipalPanelController implements ActionListener {

    private JMenuItem addOffice;
    private JMenuItem addPatient;
    private JMenuItem allOffice;
    private JMenuItem allPatient;
    private JMenuItem exit;
    private JDesktopPane escritorio;

    public PrincipalPanelController(JMenuItem exit, JMenuItem addOffice, JMenuItem allOffice,
            JDesktopPane escritorio, JMenuItem allPatient, JMenuItem addPatient) {
        super();
        this.exit = exit;
        this.addOffice = addOffice;
        this.addPatient = addPatient;
        this.allOffice = allOffice;
        this.allPatient = allPatient;
        this.escritorio = escritorio;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == addOffice) {
            try {
                loadAddOfficeForm(e);
            } catch (IOException ex) {
                Logger.getLogger(PrincipalPanelView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } if (source == addPatient) {
            try {
                loadAddPatientForm(e);
            } catch (IOException ex) {
                Logger.getLogger(PrincipalPanelView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (source == allOffice) {
            try {
                loadListOffices(e);
            } catch (IOException ex) {
                Logger.getLogger(PrincipalPanelView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (source == allPatient) {
            try {
                loadListPatients(e);
            } catch (IOException ex) {
                Logger.getLogger(PrincipalPanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (source == exit) {
            System.exit(0);
        }
    }

    private void loadAddOfficeForm(java.awt.event.ActionEvent evt) throws IOException {
        AddOfficeView ventanaInterna = new AddOfficeView();
        escritorio.add(ventanaInterna);
    }
    
    private void loadAddPatientForm(java.awt.event.ActionEvent evt) throws IOException {
        AddPatientView ventanaInterna = new AddPatientView();
        escritorio.add(ventanaInterna);
    }

    private void loadListOffices(java.awt.event.ActionEvent evt) throws JsonMappingException, IOException {
        OfficesListView ventanaInterna = new OfficesListView();
        escritorio.add(ventanaInterna);
    }

    private void loadListPatients(java.awt.event.ActionEvent evt) throws JsonMappingException, IOException {
        PatientListView ventanaInterna = new PatientListView();
        escritorio.add(ventanaInterna);
    }
}
