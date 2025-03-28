/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Attendance;
import domain.DomainObject;
import domain.OptionalProgram;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class GetAttendancesByOptionalProgramNotNullEndDate extends AbstractSO {

    private List<Attendance> attendances;

    public GetAttendancesByOptionalProgramNotNullEndDate() throws SQLException, Exception {
        super();
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<DomainObject>domainObjects=broker.get((Attendance)object);
        List<Attendance>at=new ArrayList<>();
         for (DomainObject domainObject : domainObjects) {
            at.add((Attendance)domainObject);
        }
         attendances=at;
    }

    @Override
    protected void validation(Object object) throws Exception {
         if (!(object instanceof Attendance)) {
            throw new Exception("Object is not valid");
        }
    }

}
