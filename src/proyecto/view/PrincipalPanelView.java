/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import proyecto.controller.PrincipalPanelController;

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
    JMenuItem salir = new JMenuItem();

    public PrincipalPanelView() {
        super("Panel Administrativo");

        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        setJMenuBar(principalmenu);

        // Create controller
        PrincipalPanelController controller
                = new PrincipalPanelController(salir);
        salir.addActionListener(controller);

        //set the name to components
        panel.setName("PanelAdministrativo");
        consultoriomenuitem.setName("AdminConsultorio");
        agregarconsultorio.setName("AddConsultorio");
        salir.setName("salir");

        //set the text to components
        archivomenuitem.setText("Archivo");
        consultoriomenuitem.setText("Administración Consultorio");
        agregarconsultorio.setText("Agregar Consultorio");
        salir.setText("Salir");

        //add componets
        principalmenu.add(archivomenuitem);
        principalmenu.add(consultoriomenuitem);
        consultoriomenuitem.add(agregarconsultorio);
        archivomenuitem.add(salir);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(700, 182));
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
