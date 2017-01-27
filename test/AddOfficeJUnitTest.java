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
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;
import ac.cr.una.proyecto.java.view.AddOfficeView;
import ac.cr.una.proyecto.java.view.PrincipalPanelView;

/**
 *
 * @author cristian
 */
public class AddOfficeJUnitTest {

    private FrameFixture window;
    private JPanelFixture panel;

    /**
     *
     */
    public AddOfficeJUnitTest() {

    }

    /**
     *
     * @throws IOException
     */
    @Before
    public void setUp() throws IOException {
        PrincipalPanelView frame = GuiActionRunner.execute(() -> new PrincipalPanelView());
        window = new FrameFixture(frame);
        frame.setVisible(true);
        window.show();
        frame.setExtendedState(MAXIMIZED_BOTH);
        AddOfficeView ventanaInterna = new AddOfficeView();
        window.menuItem("agregarConsultorio").click();
        ventanaInterna.setVisible(true);
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testVisibleComponents() throws IOException {
        window.label("lblName").requireVisible();
        window.label("lblPhone").requireVisible();
        window.label("lblDays").requireVisible();
        window.label("lblHourStart").requireVisible();
        window.label("lblHourEnd").requireVisible();
        window.label("lblOffice").requireVisible();
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void contentGendersComboBox() throws IOException {
        String[] offices = {"Hospital", "Clinica"};
        assertArrayEquals(window.comboBox("offices").contents(), offices);
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void isCorrectInformation() throws IOException {
        window.textBox("name").enterText("Clinica Tres Rios");
        window.textBox("phone").enterText("22796352");
        window.textBox("days").enterText("Miercoles");
        window.textBox("hourStart").enterText("800 AM");
        window.textBox("hourEnd").enterText("630 PM");
        window.comboBox("offices").selectItem("Clinica");
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
