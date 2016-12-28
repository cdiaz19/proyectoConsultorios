/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.junit.After;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import proyecto.java.view.AddOfficeView;
import proyecto.java.view.PrincipalPanelView;


/**
 *
 * @author cristian
 */
public class AddOfficeJUnitTest {

    private FrameFixture window;
    private JPanelFixture panel;

    public AddOfficeJUnitTest() {
        PrincipalPanelView frame = GuiActionRunner.execute(() -> new PrincipalPanelView());
        window = new FrameFixture(frame);
        window.show();
    }

    @Test
    public void testVisibleComponents() throws IOException {
        AddOfficeView ventanaInterna = new AddOfficeView();
        window.menuItem("agregarConsultorio").click();
        ventanaInterna.setVisible(true);

        window.label("lblName").requireVisible();
        window.label("lblPhone").requireVisible();
        window.label("lblDays").requireVisible();
        window.label("lblHourStart").requireVisible();
        window.label("lblHourEnd").requireVisible();
        window.label("lblOffice").requireVisible();
    }

    @Test
    public void contentGendersComboBox() throws IOException {
        AddOfficeView ventanaInterna = new AddOfficeView();
        window.menuItem("agregarConsultorio").click();
        ventanaInterna.setVisible(true);

        String[] offices = {"Hospital", "Clinica"};
        assertArrayEquals(window.comboBox("offices").contents(), offices);
    }

    @Test
    public void isCorrectInformation() throws IOException {
        AddOfficeView ventanaInterna = new AddOfficeView();
        window.menuItem("agregarConsultorio").click();
        ventanaInterna.setVisible(true);

        window.textBox("name").enterText("Clinica Tres Rios");
        window.textBox("phone").enterText("22796352");
        window.textBox("days").enterText("Miercoles");
        window.textBox("hourStart").enterText("8:00 AM");
        window.textBox("hourEnd").enterText("6:30 PM");
        window.comboBox("offices").selectItem("Clinica");
        window.button("ok").click();
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }
}
