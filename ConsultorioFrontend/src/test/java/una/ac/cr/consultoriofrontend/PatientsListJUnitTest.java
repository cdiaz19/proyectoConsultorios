package una.ac.cr.consultoriofrontend;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fasterxml.jackson.databind.JsonMappingException;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ac.cr.una.proyecto.java.model.Patient;
import ac.cr.una.proyecto.java.view.OfficesListView;
import ac.cr.una.proyecto.java.view.PrincipalPanelView;

/**
 *
 * @author cristian
 */
public class PatientsListJUnitTest {

    private FrameFixture window;
    private JPanelFixture panel;
    private ArrayList<Patient> patients;
    private Random randomOffice;

    /**
     *
     */
    public PatientsListJUnitTest() {

    }

    /**
     *
     * @throws JsonMappingException
     * @throws IOException
     */
    @Before
    public void setUp() throws JsonMappingException, IOException {
        PrincipalPanelView frame = GuiActionRunner.execute(() -> new PrincipalPanelView());
        window = new FrameFixture(frame);
        window.show();
        frame.setExtendedState(MAXIMIZED_BOTH);

        OfficesListView ventanaInterna = new OfficesListView();
        window.menuItem("todosPacientes").click();
        ventanaInterna.setVisible(true);
    }

    /**
     *
     */
    @Before
    public void createArrayPatients() {
        patients = new ArrayList<>();
        patients.add(new Patient("Carlos Guzman", "22795122", "Cartago",
                "19-11-1993", "Cabeza, panel", "Adicto muy Adicto"));
        patients.add(new Patient("Mario Guzman", "22795122", "Cartago",
                "19-11-1993", "Panel, panel", "Adicto muy Adicto"));
    }

    /**
     *
     * @throws JsonMappingException
     * @throws IOException
     */
    @Test
    public void testVisibleComponents() throws JsonMappingException, IOException {
        window.textBox("txtSearch").requireVisible();
        window.button("btnFilter").requireVisible();
        window.table("mainTable").requireVisible();
        window.scrollPane("scrollTablePanePatient").requireVisible();
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testSearchFilter() throws IOException {
        randomOffice = new Random();
        int index = randomOffice.nextInt(patients.size());
        Patient item = patients.get(index);
        String b = item.getName();

        window.textBox("txtSearch").enterText(b);
        window.button("btnFilter").click();
        window.table("mainTable").equals(b);
    }

    /**
     *
     */
    @After
    public void tearDown() {
        window.cleanUp();
    }
}
