/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.java.view;

import java.awt.BorderLayout;
import javafx.application.Application;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import proyecto.java.controller.PatientPanelController;

/**
 *
 * @author cristian
 */
public class PatientPanelView extends JFrame {

    // Create views swing UI components
    JMenuBar principalmenu = new JMenuBar();
    JMenu archivomenuitem = new JMenu();
    JMenuItem salir = new JMenuItem();
    JDesktopPane escritorio;

    public PatientPanelView() {
        super("Panel Paciente");
        setLayout(new BorderLayout());

        escritorio = new JDesktopPane();
        add(escritorio);

        JPanel panel = new JPanel();
        setJMenuBar(principalmenu);

        // Create controller
        PatientPanelController controller
                = new PatientPanelController(salir, escritorio);
        salir.addActionListener(controller);

        //set the name to components
        panel.setName("panelPaciente");
        escritorio.setName("escritorio");
        salir.setName("salir");

        //set the text to components
        archivomenuitem.setText("Archivo");
        salir.setText("Salir");

        //add componets
        principalmenu.add(archivomenuitem);
        archivomenuitem.add(salir);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            // ignore error
        }
    }

    public static void main(String[] arguments) {
        setLookAndFeel();
        PrincipalPanelView pp = new PrincipalPanelView();
    }
}
