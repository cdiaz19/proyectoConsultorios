package una.ac.cr.consultoriofrontend;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fasterxml.jackson.databind.JsonMappingException;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.IOException;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ac.cr.una.proyecto.java.view.AddOfficeView;
import ac.cr.una.proyecto.java.view.OfficesListView;
import ac.cr.una.proyecto.java.view.PatientListView;
import ac.cr.una.proyecto.java.view.PrincipalPanelView;

/**
 *
 * @author cristian
 */
public class PrincipalPanelJUnitTest {

    private FrameFixture window;

    /**
     *
     */
    public PrincipalPanelJUnitTest() {

    }

    /**
     *
     */
    @Before
    public void setUp() {
        PrincipalPanelView frame = GuiActionRunner.execute(() -> new PrincipalPanelView());
        window = new FrameFixture(frame);
        window.show();
        frame.setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     *
     */
    @Test
    public void testVisibleComponents() {
        window.menuItem("agregarConsultorio").requireVisible();
        window.menuItem("todosConsultorios").requireVisible();
        window.menuItem("todosPacientes").requireVisible();
        window.menuItem("salir").requireVisible();
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testOnClickAddOffice() throws IOException, Exception {
        AddOfficeView ventanaInterna = new AddOfficeView();
        window.menuItem("agregarConsultorio").click();
        ventanaInterna.setVisible(true);
    }

    /**
     *
     * @throws JsonMappingException
     * @throws IOException
     */
    @Test
    public void testOnClickAllOffices() throws JsonMappingException, IOException, Exception {
        OfficesListView ventanaInterna = new OfficesListView();
        window.menuItem("todosConsultorios").click();
        ventanaInterna.setVisible(true);
    }

    /**
     *
     * @throws JsonMappingException
     * @throws IOException
     */
    @Test
    public void testOnClickAllPatients() throws JsonMappingException, IOException {
        PatientListView ventanaInterna = new PatientListView();
        window.menuItem("todosPacientes").click();
        ventanaInterna.setVisible(true);
    }

    /**
     *
     */
    @After
    public void tearDown() {
        window.cleanUp();
    }
}
