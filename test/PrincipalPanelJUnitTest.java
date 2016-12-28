/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.junit.After;
import org.junit.Test;
import proyecto.java.view.OfficesListView;
import proyecto.java.view.PrincipalPanelView;

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
        window.menuItem("agregarConsultorio").requireVisible();
        window.menuItem("todosConsultorios").requireVisible();
        window.menuItem("salir").requireVisible();
    }

    @Test
    public void testOnClickAllOffices() throws JsonMappingException, IOException {
        OfficesListView ventanaInterna = new OfficesListView();
        window.menuItem("todosConsultorios").click();
        ventanaInterna.setVisible(true);
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }
}
