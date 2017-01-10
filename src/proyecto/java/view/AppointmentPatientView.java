/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.java.view;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import proyecto.java.controller.AppointmentPatientController;

/**
 *
 * @author Yeni
 */
public class AppointmentPatientView extends JInternalFrame {

    JTable table = new JTable();
    DefaultTableModel tableModel = new DefaultTableModel();

    /**
     *
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public AppointmentPatientView() throws JsonGenerationException,
            JsonMappingException, IOException {

        super("Lista de Citas", true, true, true, true);

        // Create table model
        table.setName("mainTable");
        table.setModel(tableModel);

        AppointmentPatientController controller = new AppointmentPatientController(tableModel);

        JPanel ctrlPane = new JPanel();
        ctrlPane.setName("ctrlPanel");

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setName("scrollTablePaneAppointment");
        tableScrollPane.setPreferredSize(new Dimension(700, 182));
        tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Citas Registradas",
                TitledBorder.CENTER, TitledBorder.TOP));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, tableScrollPane);
        splitPane.setName("splitPane");
        splitPane.setDividerLocation(35);
        splitPane.setEnabled(false);

        // Display it all in a scrolling window and make the window appear
        add(splitPane);
        pack();
        setVisible(true);

    }

}
