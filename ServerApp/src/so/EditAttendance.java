/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Attendance;
import domain.Child;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class EditAttendance extends AbstractSO{

    public EditAttendance() throws SQLException, Exception {
        super();
    }
    

    @Override
    protected void executeOperation(Object object) throws Exception {
        broker.edit((Attendance)object);
    }

    @Override
    protected void validation(Object object) throws Exception {
        if (!(object instanceof Attendance)) {
            throw new Exception("Object is not valid");
        }
        Attendance attendance = (Attendance) object;
        if (attendance.getChild() == null) {
            throw new Exception("Child is empty!");
        }
        if (attendance.getOptionalProgram()==null) {
            throw new Exception("Optional program is empty!");
        }
        if (attendance.getStartDate()==null) {
            throw new Exception("Start date is empty!");
        }
        
    }
    
}
