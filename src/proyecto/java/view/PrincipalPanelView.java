/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.java.view;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import proyecto.java.controller.PrincipalPanelController;

/**
 *
 * @author cristian
 */
public class PrincipalPanelView extends JFrame {

    // Create views swing UI components
    JMenuBar principalmenu = new JMenuBar();
    JMenu archivomenuitem = new JMenu();
    JMenu consultoriomenuitem = new JMenu();
    JMenuItem agregarconsultorio = new JMenuItem();
    JMenuItem verTodosconsultorios = new JMenuItem();
    JMenuItem salir = new JMenuItem();
    JDesktopPane escritorio;

    public PrincipalPanelView() {
        super("Panel Administrativo");
        setLayout(new BorderLayout());

        escritorio = new JDesktopPane();
        add(escritorio);

        JPanel panel = new JPanel();
        setJMenuBar(principalmenu);

        // Create controller
        PrincipalPanelController controller
                = new PrincipalPanelController(salir, agregarconsultorio, verTodosconsultorios,
                        escritorio);
        salir.addActionListener(controller);
        agregarconsultorio.addActionListener(controller);
        verTodosconsultorios.addActionListener(controller);

        //set the name to components
        panel.setName("panelAdministrativo");
        escritorio.setName("escritorio");
        consultoriomenuitem.setName("adminConsultorio");
        agregarconsultorio.setName("agregarConsultorio");
        verTodosconsultorios.setName("todosConsultorios");
        salir.setName("salir");

        //set the text to components
        archivomenuitem.setText("Archivo");
        consultoriomenuitem.setText("Administración Consultorio");
        agregarconsultorio.setText("Agregar Consultorio");
        verTodosconsultorios.setText("Ver Lista");
        salir.setText("Salir");

        //add componets
        principalmenu.add(archivomenuitem);
        principalmenu.add(consultoriomenuitem);
        consultoriomenuitem.add(agregarconsultorio);
        consultoriomenuitem.add(verTodosconsultorios);
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
