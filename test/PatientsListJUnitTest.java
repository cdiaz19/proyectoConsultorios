/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import proyecto.java.model.Clinic;
import proyecto.java.model.Hospital;
import proyecto.java.model.Office;
import proyecto.java.model.Patient;
import proyecto.java.view.OfficesListView;
import proyecto.java.view.PrincipalPanelView;

/**
 *
 * @author cristian
 */
public class PatientsListJUnitTest {

    private FrameFixture window;
    private JPanelFixture panel;
    private ArrayList<Patient> patients;
    private Random randomOffice;

    public PatientsListJUnitTest() {
        PrincipalPanelView frame = GuiActionRunner.execute(() -> new PrincipalPanelView());
        window = new FrameFixture(frame);
        window.show();
    }

    @Test
    public void testVisibleComponents() throws JsonMappingException, IOException {
        OfficesListView ventanaInterna = new OfficesListView();
        window.menuItem("todosPacientes").click();
        ventanaInterna.setVisible(true);

        window.textBox("txtSearch").requireVisible();
        window.button("btnFilter").requireVisible();
        window.table("mainTable").requireVisible();
        window.scrollPane("scrollTablePanePatient").requireVisible();
    }

    @Before
    public void createArrayPatients() {
        patients = new ArrayList<>();
        patients.add(new Patient( "Carlos Guzman", "22795122", "Cartago",
                "19-11-1993", "Cabeza, panel", "Adicto muy Adicto"));
        patients.add(new Patient( "Mario Guzman", "22795122", "Cartago",
                "19-11-1993", "Panel, panel", "Adicto muy Adicto"));
    }

    @Test
    public void testSearchFilter() throws IOException {
        OfficesListView ventanaInterna = new OfficesListView();
        window.menuItem("todosPacientes").click();
        ventanaInterna.setVisible(true);

        randomOffice = new Random();
        int index = randomOffice.nextInt(patients.size());
        Patient item = patients.get(index);
        String b = item.getName();

        window.textBox("txtSearch").enterText(b.toString());
        window.button("btnFilter").click();
        window.table("mainTable").equals(b);
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }
}
