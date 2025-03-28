/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package so;

import domain.Attendance;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class GetAllAttendancesTest {

    private GetAllAttendances so;

    @Before
    public void setUp() throws Exception {
        so = new GetAllAttendances();
    }

    @After
    public void tearDown() {
        so = null;
    }

    @Test
    public void testExecuteOperation() {
        try {
            so.executeOperation(new Attendance());
            List<Attendance> list = so.getAttendances();
            assertNotNull(list);
            assertTrue(list.size() > 0);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void testValidationValidObject() {
        try {
            so.validation(new Attendance());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testValidationInvalidObject() throws Exception {
        so.validation(new Object());
    }

}











