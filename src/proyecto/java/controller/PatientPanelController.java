/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.java.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;

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
            System.out.println("Citas Registradas");
        } else {
        }
    }
}
