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
public class QuitAttendance extends AbstractSO {

    public QuitAttendance() throws SQLException, Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        broker.edit((Attendance) object);
    }

    @Override
    protected void validation(Object object) throws Exception {
        if (!(object instanceof Attendance)) {
            throw new Exception("Object is not valid");
        }

    }

}
