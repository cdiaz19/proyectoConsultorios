/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Test;
import proyecto.java.view.PatientPanelView;

/**
 *
 * @author cristian
 */
public class PatientPanelJUnitTest {
    
    private FrameFixture window;

    public PatientPanelJUnitTest() {
        PatientPanelView frame = GuiActionRunner.execute(() -> new PatientPanelView());
        window = new FrameFixture(frame);
        window.show();
    }

    @Test
    public void testVisibleComponents() {
        window.menuItem("salir").requireVisible();
    }
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
}
