/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author cristian
 */
public class PrincipalPanelController implements ActionListener{
   
    private JMenuItem Exit;

    public PrincipalPanelController(JMenuItem Exit) {
        super();
        this.Exit = Exit;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }    
}
