/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static java.awt.Frame.MAXIMIZED_BOTH;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import proyecto.java.view.PatientPanelView;

/**
 *
 * @author cristian
 */
public class PatientPanelJUnitTest {

    private FrameFixture window;

    /**
     *
     */
    public PatientPanelJUnitTest() {

    }

    /**
     *
     */
    @Before
    public void setUp() {
        PatientPanelView frame = GuiActionRunner.execute(() -> new PatientPanelView());
        window = new FrameFixture(frame);
        window.show();
        frame.setExtendedState(MAXIMIZED_BOTH);

    }

    /**
     *
     */
    @Test
    public void testVisibleComponents() {
        window.menuItem("citasPaciente").requireVisible();
        window.menuItem("informacionPersonal").requireVisible();
        window.menuItem("salir").requireVisible();
    }

    /**
     *
     */
    @Test
    public void testOnClickPersonalInformation() {
        window.menuItem("informacionPersonal").click();
    }

    /**
     *
     */
    @Test
    public void testOnClickAppointmentPatient() {
        window.menuItem("citasPaciente").click();
    }

    /**
     *
     */
    @After
    public void tearDown() {
        window.cleanUp();
    }
}
