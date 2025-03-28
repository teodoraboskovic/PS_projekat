/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Attendance;
import domain.Child;
import domain.DomainObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class GetAllAttendances extends AbstractSO{

    public GetAllAttendances() throws SQLException, Exception {
        super();
    }
    
    List<Attendance>attendances;

    public List<Attendance> getAttendances() {
        return attendances;
    }
    

    @Override
    protected void executeOperation(Object object) throws Exception {
        attendances=new ArrayList<>();
        List<DomainObject>domainObjects=broker.get((Attendance)object);
        for (DomainObject domainObject : domainObjects) {
            attendances.add((Attendance)domainObject);
        }
    }

    @Override
    protected void validation(Object object) throws Exception {
        if(!(object instanceof Attendance)){
            throw new Exception("Object is not valid");
        }
    }
    
}
