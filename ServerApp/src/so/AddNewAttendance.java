/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Attendance;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PC
 */
public class AddNewAttendance extends AbstractSO {

    public AddNewAttendance() throws SQLException, Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<?> list = (List<?>) object;
        for (Object item : list) {
            broker.add((Attendance) item);
        }

    }

    @Override
    protected void validation(Object object) throws Exception {
        if (object instanceof List<?>) {
            List<?> list = (List<?>) object;
            for (Object item : list) {
                if (!(item instanceof Attendance)) {
                    throw new Exception("Object is not valid");
                }
            }
        }
        List<Attendance> attendances = (List<Attendance>) object;
        for (Attendance attendance : attendances) {
            if (attendance.getChild() == null) {
                throw new Exception("Child is empty!");
            }
            if (attendance.getStartDate() == null) {
                throw new Exception("Start date is empty!");
            }
            if (attendance.getOptionalProgram() == null) {
                throw new Exception("Optional program is empty!");
            }
        }

    }

}
