package una.ac.cr.consultoriofrontend;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.IOException;
import java.text.ParseException;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ac.cr.una.proyecto.java.view.AddAppointmentView;
import ac.cr.una.proyecto.java.view.PrincipalPanelView;

/**
 *
 * @author Yeni
 */
public class AddAppointmentJUnitTest {

    private FrameFixture window;
    private JPanelFixture panel;

    /**
     *
     */
    public AddAppointmentJUnitTest() {
    }

    /**
     *
     * @throws IOException
     */
    @Before
    public void setUp() throws IOException, Exception {
        PrincipalPanelView frame = GuiActionRunner.execute(() -> new PrincipalPanelView());
        window = new FrameFixture(frame);
        frame.setVisible(true);
        window.show();
        frame.setExtendedState(MAXIMIZED_BOTH);
        AddAppointmentView ventanaInterna = new AddAppointmentView();
        window.menuItem("agregarCita").click();

        ventanaInterna.setVisible(true);
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testVisibleComponents() throws IOException {
        window.label("lblName").requireVisible();
        window.label("lblOffice").requireVisible();
        window.label("lblDate").requireVisible();
        window.label("lblHour").requireVisible();
    }

    /**
     *
     * 
     */
    @Test
    public void isCorrectInformation() {
        window.textBox("name").enterText("Valeria");
        window.comboBox("office").selectItem("Hospital CIMA");
        window.panel("date").textBox().enterText("12-01-2017");
        window.comboBox("hour").selectItem("10:00am");
        window.button("ok").click();
    }

    /**
     *
     */
    @After
    public void tearDown() {
        window.cleanUp();
    }
}
