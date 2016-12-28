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
import proyecto.model.Clinic;
import proyecto.model.Hospital;
import proyecto.model.Office;
import proyecto.view.OfficesListView;
import proyecto.view.PrincipalPanelView;

/**
 *
 * @author cristian
 */
public class OfficesListUnitTest {

    private FrameFixture window;
    private JPanelFixture panel;
    private ArrayList<Office> offices;
    private Random randomOffice;

    public OfficesListUnitTest() {
        PrincipalPanelView frame = GuiActionRunner.execute(() -> new PrincipalPanelView());
        window = new FrameFixture(frame);
        window.show();
    }

    @Test
    public void testVisibleComponents() throws JsonMappingException, IOException {
        OfficesListView ventanaInterna = new OfficesListView();
        window.menuItem("todosConsultorios").click();
        ventanaInterna.setVisible(true);

        window.textBox("txtSearch").requireVisible();
        window.button("btnFilter").requireVisible();
        window.table("mainTable").requireVisible();
        window.scrollPane("scrollTablePaneOffice").requireVisible();
    }

    @Before
    public void createArrayOffices() {
        offices = new ArrayList<>();
        offices.add(new Hospital("Hospital CIMA", "22795122", "Lunes y Martes", "8:00", "5:00"));
        offices.add(new Clinic("Centro Médico del Este", "22792761", "Jueves y Viernes", "8:00", "5:00"));
    }

    @Test
    public void testSearchFilter() throws IOException {
        OfficesListView ventanaInterna = new OfficesListView();
        window.menuItem("todosConsultorios").click();
        ventanaInterna.setVisible(true);

        randomOffice = new Random();
        int index = randomOffice.nextInt(offices.size());
        Office item = offices.get(index);
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
