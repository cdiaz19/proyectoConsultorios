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
import org.assertj.swing.fixture.JPanelFixture;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import proyecto.java.view.AppointmentListView;
import proyecto.java.view.OfficesListView;
import proyecto.java.view.PrincipalPanelView;

/**
 *
 * @author Yeni
 */
public class AppointmentListJUnit {
    private FrameFixture window;
    private JPanelFixture panel;
    
    public AppointmentListJUnit() {
    }
    
    @Before
    public void setUp() throws JsonMappingException, IOException {
        PrincipalPanelView frame = GuiActionRunner.execute(() -> new PrincipalPanelView());
        window = new FrameFixture(frame);
        window.show();
        frame.setExtendedState(MAXIMIZED_BOTH);
        AppointmentListView ventanaInterna = new AppointmentListView();
        window.menuItem("todasCitas").click();
        ventanaInterna.setVisible(true);
    }
    
    @Test
    public void testVisibleComponents() throws JsonMappingException, IOException {
        window.textBox("txtSearch").requireVisible();
        window.button("btnFilter").requireVisible();
        window.table("mainTable").requireVisible();
        window.scrollPane("scrollTablePaneAppointment").requireVisible();
    }
    
     @Test
    public void searchFilter() throws IOException {
        window.textBox("txtSearch").enterText("Hospital CIMA");
        window.button("btnFilter").click();
        window.table("mainTable").equals("Hospital CIMA");
    }
    
    @After
    public void tearDown() {
        window.cleanUp();
    }

}
