/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.java.view;

import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
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
    JMenu pacientemenuitem = new JMenu();
    JMenu citamenuitem = new JMenu();
    JMenuItem agregarconsultorio = new JMenuItem();
    JMenuItem agregarpaciente = new JMenuItem();
    JMenuItem verTodospacientes = new JMenuItem();
    JMenuItem verTodosconsultorios = new JMenuItem();
    JMenuItem agregarcita = new JMenuItem();
    JMenuItem verTodascitas = new JMenuItem();
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
                        escritorio, verTodospacientes, agregarpaciente,agregarcita, verTodascitas);
        salir.addActionListener(controller);
        agregarconsultorio.addActionListener(controller);
        agregarpaciente.addActionListener(controller);
        verTodosconsultorios.addActionListener(controller);
        verTodospacientes.addActionListener(controller);
        agregarcita.addActionListener(controller);
        verTodascitas.addActionListener(controller);

        //set the name to components
        panel.setName("panelAdministrativo");
        escritorio.setName("escritorio");
        consultoriomenuitem.setName("adminConsultorio");
        pacientemenuitem.setName("adminPaciente");
        agregarconsultorio.setName("agregarConsultorio");
        verTodosconsultorios.setName("todosConsultorios");
        pacientemenuitem.setName("adminPaciente");
        agregarpaciente.setName("agregarPaciente");
        verTodospacientes.setName("todosPacientes");
        citamenuitem.setName("adminCitas");
        agregarcita.setName("agregarCita");
        verTodascitas.setName("todasCitas");
        salir.setName("salir");

        //set the text to components
        archivomenuitem.setText("Archivo");
        consultoriomenuitem.setText("Administración Consultorio");
        agregarconsultorio.setText("Agregar Consultorio");
        verTodosconsultorios.setText("Ver Lista");
        pacientemenuitem.setText("Administración Pacientes");
        agregarpaciente.setText("Agregar Paciente");
        verTodospacientes.setText("Ver Lista");
        citamenuitem.setText("Administracion de Citas");
        agregarcita.setText("Agregar Cita");
        verTodascitas.setText("Ver Lista");
        salir.setText("Salir");

        //add componets
        principalmenu.add(archivomenuitem);
        principalmenu.add(consultoriomenuitem);
        principalmenu.add(pacientemenuitem);
        principalmenu.add(citamenuitem);
        consultoriomenuitem.add(agregarconsultorio);
        consultoriomenuitem.add(verTodosconsultorios);
        pacientemenuitem.add(agregarpaciente);
        pacientemenuitem.add(verTodospacientes);
        archivomenuitem.add(salir);
        citamenuitem.add(agregarcita);
        citamenuitem.add(verTodascitas);

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
