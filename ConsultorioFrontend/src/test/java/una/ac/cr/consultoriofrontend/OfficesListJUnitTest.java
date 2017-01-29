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
import ac.cr.una.proyecto.java.model.Office;
import ac.cr.una.proyecto.java.view.OfficesListView;
import ac.cr.una.proyecto.java.view.PrincipalPanelView;

/**
 *
 * @author cristian
 */
public class OfficesListJUnitTest {

    private FrameFixture window;
    private JPanelFixture panel;
    private ArrayList<Office> offices;
    private Random randomOffice;

    /**
     *
     */
    public OfficesListJUnitTest() {
    }

    /**
     *
     * @throws JsonMappingException
     * @throws IOException
     */
    @Before
    public void setUp() throws JsonMappingException, IOException, Exception {
        PrincipalPanelView frame = GuiActionRunner.execute(() -> new PrincipalPanelView());
        window = new FrameFixture(frame);
        window.show();
        frame.setExtendedState(MAXIMIZED_BOTH);
        OfficesListView ventanaInterna = new OfficesListView();
        window.menuItem("todosConsultorios").click();
        ventanaInterna.setVisible(true);
    }

    /**
     *
     */
    @Before
    public void createArrayOffices() {
        offices = new ArrayList<>();
        offices.add(new Office(1, "Hospital CIMA", "22795122", "Lunes y Martes", "8:00", "5:00"));
        offices.add(new Office(2, "Centro Médico del Este", "22792761", "Jueves y Viernes", "8:00", "5:00"));
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
        window.scrollPane("scrollTablePaneOffice").requireVisible();
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testSearchFilter() throws IOException {
        randomOffice = new Random();
        int index = randomOffice.nextInt(offices.size());
        Office item = offices.get(index);
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
