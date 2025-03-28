/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Attendance;
import domain.Child;
import domain.EditAndDeleteList;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PC
 */
public class EditAndDeleteAttendances extends AbstractSO {

    public EditAndDeleteAttendances() throws SQLException, Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        EditAndDeleteList editAndDeleteList = (EditAndDeleteList) object;
        List<Attendance> editedAttendances = editAndDeleteList.getEditList();
        List<Attendance> deletedAttendances = editAndDeleteList.getDeleteList();
        for (Attendance editedAttendance : editedAttendances) {
            broker.edit(editedAttendance);
        }
        for (Attendance deletedAttendance : deletedAttendances) {
            broker.delete(deletedAttendance);
        }
    }

    @Override
    protected void validation(Object object) throws Exception {
        if (!(object instanceof EditAndDeleteList)) {
            throw new Exception("Object is not valid");
        }
        EditAndDeleteList editAndDeleteList = (EditAndDeleteList) object;
        List<Attendance> editedAttendances = editAndDeleteList.getEditList();
        List<Attendance> deletedAttendances = editAndDeleteList.getDeleteList();
        for (Attendance editedAttendance : editedAttendances) {
            if (editedAttendance.getChild() == null) {
                throw new Exception("Child is empty!");
            }
            if (editedAttendance.getOptionalProgram() == null) {
                throw new Exception("Optional program is empty!");
            }
            if (editedAttendance.getStartDate() == null) {
                throw new Exception("Start date is empty!");
            }
        }

    }

}
