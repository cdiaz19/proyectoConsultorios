/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto.Constants;
import proyecto.service.OfficeService;

/**
 *
 * @author cristian
 */
public class OfficeListController implements ActionListener {

    private JTextField searchOfficeTextField = new JTextField(26);
    private DefaultTableModel tableModel;
    private OfficeService officeService;
    private Object[][] offices;

    /**
     * Main Constructor
     *
     * @param searchTermTextField
     * @param tableModel
     *
     * @throws com.fasterxml.jackson.core.JsonGenerationException
     * @throws com.fasterxml.jackson.databind.JsonMappingException
     * @throws java.io.IOException
     */
    public OfficeListController(JTextField searchTermTextField,
            DefaultTableModel tableModel) throws JsonGenerationException,
            JsonMappingException, IOException {
        super();
        officeService = new OfficeService();
        offices = officeService.loadOfficesObjWrapper();

        this.searchOfficeTextField = searchTermTextField;
        this.tableModel = tableModel;

        // Load the table with the list of students
        tableModel.setDataVector(offices, Constants.TABLE_HEADER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String searchTerm = searchOfficeTextField.getText();

        //Method to search items
        updateTableSearchTerms(searchTerm);
    }

    private void updateTableSearchTerms(String searchTerm) {
        if (searchTerm != null && !"".equals(searchTerm)
                && offices != null && offices.length > 1) {
            Object[][] newData = new Object[offices.length][];
            int idx = 0;
            for (Object[] obj : offices) {
                String fullText = obj[0].toString() + obj[1].toString()
                        + obj[2].toString() + obj[3].toString();

                if (fullText.contains(searchTerm.trim())) {
                    newData[idx++] = obj;
                }
            }
            tableModel.setDataVector(newData, Constants.TABLE_HEADER);
        } else {
            JOptionPane.showMessageDialog(null,
                    "La busqueda esta vacia", "Error",
                    JOptionPane.ERROR_MESSAGE);
            tableModel.setDataVector(offices, Constants.TABLE_HEADER);
        }
    }
}
