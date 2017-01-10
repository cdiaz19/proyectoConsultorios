/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.java.view;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyecto.java.controller.AppointmentPatientController;

/**
 *
 * @author Yeni
 */
public class AppointmentPatientView extends JInternalFrame {
    JButton verify= new JButton("Buscar Citas");
    JTable table = new JTable();
    DefaultTableModel tableModel;
    
    public AppointmentPatientView() throws JsonGenerationException,
            JsonMappingException, IOException {

        super("Lista de Citas", true, true, true, true);
        verify.setName("btnFilter");

        // Create table model
        table.setName("mainTable");
        table.setModel(tableModel);
        
        AppointmentPatientController controller = new AppointmentPatientController(verify,tableModel);
        verify.addActionListener(controller);
    }
    
}
