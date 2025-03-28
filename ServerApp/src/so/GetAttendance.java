/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Attendance;
import domain.DomainObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author PC
 */
public class GetAttendance extends AbstractSO {

    public GetAttendance() throws SQLException, Exception {
        super();
    }

    private Attendance attendance;

    public Attendance getAttendance() {
        return attendance;
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<DomainObject> domainObjects = broker.get((Attendance) object);
        List<Attendance> attendances = new ArrayList<>();
        for (DomainObject domainObject : domainObjects) {
            attendances.add((Attendance) domainObject);
        }
        if (!attendances.isEmpty()) {
            attendance = attendances.get(0);
        }

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
        if (attendance.getStartDate() == null) {
            throw new Exception("Start date is empty!");
        }
        if (attendance.getOptionalProgram() == null) {
            throw new Exception("Optional program is empty!");
        }

    }

}
