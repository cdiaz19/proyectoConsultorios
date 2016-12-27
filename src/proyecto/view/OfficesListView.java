/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.view;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import proyecto.controller.OfficeController;

/**
 *
 * @author cristian
 */
public class OfficesListView extends JFrame {
   // Create views swing UI components 

    JTextField searchTermTextField = new JTextField(26);
    JButton filterButton = new JButton("Filtro");
    JTable table = new JTable();
    DefaultTableModel tableModel = new DefaultTableModel();

    /**
     * Main Constructor
     *
     * @throws com.fasterxml.jackson.core.JsonGenerationException
     * @throws com.fasterxml.jackson.databind.JsonMappingException
     * @throws java.io.IOException
     */
    public OfficesListView() throws JsonGenerationException,
            JsonMappingException, IOException {
        
        super("Lista de Consultorios");
        
        searchTermTextField.setName("txtSearch");
        filterButton.setName("btnFilter");

        // Create table model
        table.setName("mainTable");
        table.setModel(tableModel);

        // Create controller
        OfficeController controller = new OfficeController(searchTermTextField, tableModel);
        filterButton.addActionListener(controller);

        // Set the view layout
        JPanel ctrlPane = new JPanel();
        ctrlPane.setName("ctrlPanel");
        ctrlPane.add(searchTermTextField);
        ctrlPane.add(filterButton);
        
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setName("scrollTablePaneOffice");
        tableScrollPane.setPreferredSize(new Dimension(700, 182));
        tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Consultorios Registrados",
                TitledBorder.CENTER, TitledBorder.TOP));
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, tableScrollPane);
        splitPane.setName("splitPane");
        splitPane.setDividerLocation(35);
        splitPane.setEnabled(false);

        // Display it all in a scrolling window and make the window appear
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(splitPane);
        pack();
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
