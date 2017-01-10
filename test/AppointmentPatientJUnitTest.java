/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.IOException;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import proyecto.java.view.AddPatientView;
import proyecto.java.view.InformationPatientView;
import proyecto.java.view.PatientPanelView;
import proyecto.java.view.PrincipalPanelView;
import static proyecto.java.Constants.ACTUAL;

/**
 *
 * @author Yeni
 */
public class AppointmentPatientJUnitTest {
    
    private FrameFixture window;
    private JPanelFixture panel;
    
    public AppointmentPatientJUnitTest() {
    }
    
    @Before
    public void setUp() throws IOException {
        //Valor de prueba para test
        ACTUAL = "Santiago"; //Nombre del paciente
        PatientPanelView frame = GuiActionRunner.execute(() -> new PatientPanelView());
        window = new FrameFixture(frame);
        window.show();
        frame.setExtendedState(MAXIMIZED_BOTH);
        InformationPatientView ventanaInterna = new InformationPatientView();
        window.menuItem("citasPaciente").click();
        ventanaInterna.setVisible(true);
    }
    
    @Test
    public void testVisibleComponents() throws IOException {
        window.table("mainTable").requireVisible();
        window.scrollPane("scrollTablePaneAppointment").requireVisible();
    }
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
    
}
