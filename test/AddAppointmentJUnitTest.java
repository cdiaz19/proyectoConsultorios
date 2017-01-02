/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.IOException;
import javax.swing.JFrame;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.junit.After;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import proyecto.java.view.AddAppointmentView;
import proyecto.java.view.PrincipalPanelView;

/**
 *
 * @author Yeni
 */
public class AddAppointmentJUnitTest {

    private FrameFixture window;
    private JPanelFixture panel;

    public AddAppointmentJUnitTest() {
        PrincipalPanelView frame = GuiActionRunner.execute(() -> new PrincipalPanelView());
        window = new FrameFixture(frame);
        frame.setVisible(true);
        window.show();

    }

    @Test
    public void testVisibleComponents() throws IOException {
        AddAppointmentView ventanaInterna = new AddAppointmentView();
        window.menuItem("agregarCita").click();
        ventanaInterna.setVisible(true);

        window.label("lblName").requireVisible();
        window.label("lblOffice").requireVisible();
        window.label("lblDate").requireVisible();
        window.label("lblHour").requireVisible();
    }

    @Test
    public void isCorrectInformation() throws IOException {
        AddAppointmentView ventanaInterna = new AddAppointmentView();
        window.menuItem("agregarCita").click();
        ventanaInterna.setVisible(true);
        
        window.textBox("name").enterText("Maria");
        window.comboBox("office").selectItem("Hospital CIMA");
        window.comboBox("hour").selectItem("10:00am");
        window.button("ok").click();
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }
}
