/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package so;

import domain.UserProfile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class LoginTest {

    private Login so;
    private UserProfile user;

    @Before
    public void setUp() throws Exception {
        so = new Login();
        user = new UserProfile();
    }

    @After
    public void tearDown() {
        so = null;
        user = null;
    }

    @Test
    public void testExecuteOperationSuccessful() {
        try {
            user.setUsername("ana");
            user.setPassword("ana123");
            so.executeOperation(user);
            assertNotNull(so.getUser());
            assertEquals("ana", so.getUser().getUsername());
            assertEquals("ana123", so.getUser().getPassword());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testExecuteOperationUnsuccessful() throws Exception {
        user.setUsername("ana");
        user.setPassword("ana1234");
        so.executeOperation(user);
    }

    @Test
    public void testValidationValidObject() {
        try {
            user.setUsername("username");
            user.setPassword("password");
            so.validation(user);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testValidationInvalidObject() throws Exception {
        so.validation(new Object());
    }

    @Test(expected = Exception.class)
    public void testValidationEmptyUsername() throws Exception {
        user.setUsername(null);
        user.setPassword("password");
        so.validation(user);
    }

    @Test(expected = Exception.class)
    public void testValidationEmptyPassword() throws Exception {
        user.setUsername("username");
        user.setPassword(null);
        so.validation(user);
    }

    @Test(expected = Exception.class)
    public void testValidationInvalidUsername() throws Exception {
        user.setUsername("usernamewithmorethanthirtycharacters");
        user.setPassword("password");
        so.validation(user);
    }

    @Test(expected = Exception.class)
    public void testValidationInvalidPassword() throws Exception {
        user.setUsername("username");
        user.setPassword("passwordwithmorethanthirtycharacters");
        so.validation(user);
    }

}









