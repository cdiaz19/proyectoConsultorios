/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.junit.After;
import org.junit.Test;
import proyecto.view.PrincipalPanelView;

/**
 *
 * @author cristian
 */
public class PrincipalPanelJUnitTest {

    private FrameFixture window;

    public PrincipalPanelJUnitTest() {
        PrincipalPanelView frame = GuiActionRunner.execute(() -> new PrincipalPanelView());
        window = new FrameFixture(frame);
        window.show();
    }

    @Test
    public void testVisibleComponents() {
        window.menuItem("AddConsultorio").requireVisible();
        window.menuItem("salir").requireVisible();
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }
}
