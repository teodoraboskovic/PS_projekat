/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package so;

import domain.Attendance;
import domain.Child;
import domain.EditAndDeleteList;
import domain.OptionalProgram;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class EditAndDeleteAttendancesTest {

    private EditAndDeleteAttendances so;
    private EditAndDeleteList editAndDeleteList;
    private Attendance attendance;
    List<Attendance> editedA;
    List<Attendance> deletedA;

    @Before
    public void setUp() throws Exception {
        so = new EditAndDeleteAttendances();
        attendance = new Attendance();
        editedA = new ArrayList<>();
        deletedA = new ArrayList<>();
        editAndDeleteList = 
                new EditAndDeleteList(editedA, deletedA);
    }

    @After
    public void tearDown() {
        so = null;
        attendance = null;
        editedA = null;
        deletedA = null;
        editAndDeleteList = null;
    }

    @Test
    public void testExecuteOperation() throws Exception {
        // Kreiramo objekat za izmenu
        OptionalProgram optionalProgram1 = new OptionalProgram();
        optionalProgram1.setId(6l);
        Child child1 = new Child();
        child1.setId(2l);
        Attendance attendanceToEdit = new Attendance();
        attendance.setChild(child1);
        attendance.setOptionalProgram(optionalProgram1);
        attendanceToEdit.setChild(child1);
        attendanceToEdit.setOptionalProgram(optionalProgram1);
        attendanceToEdit.setStartDate(new java.sql.Date(new Date().getTime()));
        attendanceToEdit.setEndDate(new java.sql.Date(new Date().getTime()));
        attendanceToEdit.setOldAttendance(attendance);
        editedA.add(attendanceToEdit);

        // Kreiramo objekat za brisanje
        OptionalProgram optionalProgram2 = new OptionalProgram();
        optionalProgram2.setId(4l);
        Child child2 = new Child();
        child2.setId(2l);
        Attendance attendanceToDelete = new Attendance();
        attendanceToDelete.setChild(child2);
        attendanceToDelete.setOptionalProgram(optionalProgram2);
        deletedA.add(attendanceToDelete);

        editAndDeleteList.setEditList(editedA);
        editAndDeleteList.setDeleteList(deletedA);
        so.executeOperation(editAndDeleteList);
        so.broker.getConnection().commit();

        GetAllAttendances getAllAttendances = new GetAllAttendances();
        getAllAttendances.executeOperation(new Attendance());
        List<Attendance> allAttendances = getAllAttendances.getAttendances();

        // Proveravamo da li objekat za izmenu postoji i da je ažuriran
        Attendance editedFromDB = null;
        for (Attendance att : allAttendances) {
            if (Objects.equals(att.getChild().getId(), 
                    attendanceToEdit.getChild().getId())
                    && Objects.equals(att.getOptionalProgram().getId(),
                            attendanceToEdit.getOptionalProgram().getId())) {
                editedFromDB = att;
                break;
            }
        }
        assertNotNull(editedFromDB);
        assertEquals(optionalProgram1.getId(), 
                editedFromDB.getOptionalProgram().getId());
        assertEquals(child1.getId(), 
                editedFromDB.getChild().getId());
        assertEquals(attendanceToEdit.getStartDate(), 
                editedFromDB.getStartDate());
        assertEquals(attendanceToEdit.getEndDate(), 
                editedFromDB.getEndDate());

//         Proveravamo da objekat za brisanje ne postoji u bazi
        Attendance deletedFromDB = null;
        for (Attendance att : allAttendances) {
            if (Objects.equals(att.getChild().getId(), 
                    attendanceToDelete.getChild().getId())
                    && Objects.equals(att.getOptionalProgram().getId(), 
                            attendanceToDelete.getOptionalProgram().getId())) {
                deletedFromDB = att;
                break;
            }
        }
        assertNull(deletedFromDB);
    }

    @Test
    public void testValidationValidObject() {
        try {
            OptionalProgram optionalProgram = new OptionalProgram();
            Child child = new Child();
            attendance.setChild(child);
            attendance.setOptionalProgram(optionalProgram);
            attendance.setStartDate(new Date());
            attendance.setEndDate(new Date());
            editedA.add(attendance);
            editAndDeleteList.setEditList(editedA);
            deletedA.add(attendance);
            editAndDeleteList.setDeleteList(deletedA);
            so.validation(editAndDeleteList);
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
        editedA.add(attendance);
        editAndDeleteList.setEditList(editedA);
        so.validation(editAndDeleteList);
    }

    @Test(expected = Exception.class)
    public void testValidationEmptyStartDate() throws Exception {
        OptionalProgram optionalProgram = new OptionalProgram();
        Child child = new Child();
        attendance.setChild(child);
        attendance.setOptionalProgram(optionalProgram);
        attendance.setStartDate(null);
        editedA.add(attendance);
        editAndDeleteList.setEditList(editedA);
        so.validation(editAndDeleteList);
    }

    @Test(expected = Exception.class)
    public void testValidationEmptyOptionalProgram() throws Exception {
        OptionalProgram optionalProgram = null;
        Child child = new Child();
        attendance.setChild(child);
        attendance.setOptionalProgram(optionalProgram);
        attendance.setStartDate(new Date());
        editedA.add(attendance);
        editAndDeleteList.setEditList(editedA);
        so.validation(editAndDeleteList);
    }
}
