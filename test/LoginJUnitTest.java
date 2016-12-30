/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.Before;
import proyecto.java.view.LoginView;
import proyecto.java.view.PrincipalPanelView;

/**
 *
 * @author Kimberly
 */
public class LoginJUnitTest {
    private FrameFixture window;
    
    /**
     *
     */
    public LoginJUnitTest() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
        LoginView frame = GuiActionRunner.execute(() -> new LoginView());
        window = new FrameFixture(frame);
        window.show();
    }
    
    /**
     *
     */
    @Test
    public void testVisibleComponents() {
        window.label("lblUsername").requireVisible();
        window.label("lblPassword").requireVisible();
    }
    
    /**
     *
     */
    @Test
    public void isCorrectUserTest(){
        String pass = "1234";
        char[] c = pass.toCharArray();
        window.textBox("username").enterText("Juan");
       // window.textBox("password").;
        window.button("Login").click();
        assertEquals(window.textBox("username").text(), "Juan");
    }
    
    /**
     *
     */
    @Test
    public void isInCorrectUserTest(){
        String pass = "1234";
        char[] c = pass.toCharArray();
        window.textBox("username").enterText("Carlos");
       // window.textBox("password").;
        window.button("Login").click();
        assertNotEquals(window.textBox("username").text(), "Juan");
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
        window.cleanUp();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
