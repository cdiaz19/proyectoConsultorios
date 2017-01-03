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
import proyecto.java.view.AddAppointmentView;
import proyecto.java.view.AddOfficeView;
import proyecto.java.view.AddPatientView;
import proyecto.java.view.AppointmentListView;
import proyecto.java.view.OfficesListView;
import proyecto.java.view.PatientListView;
import proyecto.java.view.PrincipalPanelView;

/**
 *
 * @author cristian
 */
public class PatientPanelController implements ActionListener {

    private JMenuItem exit;
    private JDesktopPane escritorio;

    public PatientPanelController(JMenuItem exit, JDesktopPane escritorio) {
        super();
        this.exit = exit;
        this.escritorio = escritorio;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == exit) {
            System.exit(0);
        } else {
        }
    }
}
