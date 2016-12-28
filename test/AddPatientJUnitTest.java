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
import org.junit.Test;
import static org.junit.Assert.*;
import proyecto.java.view.AddOfficeView;
import proyecto.java.view.AddPatientView;
import proyecto.java.view.PrincipalPanelView;

/**
 *
 * @author cristian
 */
public class AddPatientJUnitTest {

    private FrameFixture window;
    private JPanelFixture panel;

    public AddPatientJUnitTest() {
        PrincipalPanelView frame = GuiActionRunner.execute(() -> new PrincipalPanelView());
        window = new FrameFixture(frame);
        window.show();
    }

    @Test
    public void testVisibleComponents() throws IOException {
        AddPatientView ventanaInterna = new AddPatientView();
        window.menuItem("agregarPaciente").click();
        ventanaInterna.setVisible(true);

        window.label("lblName").requireVisible();
        window.label("lblPhone").requireVisible();
        window.label("lblAddress").requireVisible();
        window.label("lblBirthday").requireVisible();
        window.label("lblAssociatedDiseases").requireVisible();
        window.label("lblObservation").requireVisible();
    }

    @Test
    public void isCorrectInformation() throws IOException {
        AddPatientView ventanaInterna = new AddPatientView();
        window.menuItem("agregarPaciente").click();
        ventanaInterna.setVisible(true);

        window.textBox("name").enterText("Santiago Gonzalez");
        window.textBox("phone").enterText("22795352");
        window.textBox("address").enterText("Alajuela");
        window.textBox("birthday").enterText("23-12-1985");
        window.textBox("associatedDiseases").enterText("Neumonia");
        window.textBox("observations").enterText("Fuerte dolor en el pecho, "
                + "cuesta respirar");
        window.button("ok").click();
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }
}
