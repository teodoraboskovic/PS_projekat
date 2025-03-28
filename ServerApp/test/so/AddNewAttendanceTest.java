/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package so;

import domain.Attendance;
import domain.Child;
import domain.OptionalProgram;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class AddNewAttendanceTest {

    private AddNewAttendance so;
    private GetAllAttendances getAllAttendances;
    private Attendance attendance;
    List<Attendance> attendances;

    @Before
    public void setUp() throws Exception {
        so = new AddNewAttendance();
        attendance = new Attendance();
        getAllAttendances = new GetAllAttendances();
        attendances=new ArrayList<>();
    }

    @After
    public void tearDown() {
        so = null;
        attendance = null;
        getAllAttendances = null;
        attendances=null;
    }

    @Test
    public void testExecuteOperation() throws Exception {
        OptionalProgram optionalProgram = new OptionalProgram();
        optionalProgram.setId(6l);
        Child child = new Child();
        child.setId(4l);
        attendance.setChild(child);
        attendance.setOptionalProgram(optionalProgram);
        attendance.setStartDate(new Date());
        attendances.add(attendance);
        getAllAttendances = new GetAllAttendances();
        getAllAttendances.executeOperation(new Attendance());
        List<Attendance> attendancesBeforeAdd = getAllAttendances.getAttendances();
        so.executeOperation(attendances);
        so.broker.getConnection().commit();
        getAllAttendances = new GetAllAttendances();
        getAllAttendances.executeOperation(new Attendance());
        List<Attendance> attendancesAfterAdd = getAllAttendances.getAttendances();
        assertEquals(attendancesBeforeAdd.size() + 1, attendancesAfterAdd.size());
    }

    @Test
    public void testValidationValidObject() {
        try {
            OptionalProgram optionalProgram = new OptionalProgram();
            Child child = new Child();
            attendance.setChild(child);
            attendance.setOptionalProgram(optionalProgram);
            attendance.setStartDate(new Date());
            List<Attendance> attendances = new ArrayList<>();
            attendances.add(attendance);
            so.validation(attendances);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testValidationInvalidObject() throws Exception {
        so.validation(new Object());
    }

    @Test(expected = Exception.class)
    public void testValidationEmptyChild() throws Exception {
        OptionalProgram optionalProgram = new OptionalProgram();
        Child child = null;
        attendance.setChild(child);
        attendance.setOptionalProgram(optionalProgram);
        attendance.setStartDate(new Date());
        List<Attendance> attendances = new ArrayList<>();
        attendances.add(attendance);
        so.validation(attendances);
    }

    @Test(expected = Exception.class)
    public void testValidationEmptyStartDate() throws Exception {
        OptionalProgram optionalProgram = new OptionalProgram();
        Child child = new Child();
        attendance.setChild(child);
        attendance.setOptionalProgram(optionalProgram);
        attendance.setStartDate(null);
        List<Attendance> attendances = new ArrayList<>();
        attendances.add(attendance);
        so.validation(attendances);
    }

    @Test(expected = Exception.class)
    public void testValidationEmptyOptionalProgram() throws Exception {
        OptionalProgram optionalProgram = null;
        Child child = new Child();
        attendance.setChild(child);
        attendance.setOptionalProgram(optionalProgram);
        attendance.setStartDate(new Date());
        List<Attendance> attendances = new ArrayList<>();
        attendances.add(attendance);
        so.validation(attendances);
    }
}










