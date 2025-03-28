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
import java.util.Objects;

/**
 *
 * @author PC
 */
public class GetSearchedAttendances extends AbstractSO {

    public GetSearchedAttendances() throws SQLException, Exception {
        super();
    }
    

    private List<Attendance> attendances;

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
//        Attendance attendance=(Attendance) object;
//         if(attendance.getChild().getJmbg()==0l){
//             throw new Exception("JMBG is empty!");
//        }
//         for (int i = 0; i < attendance.getChild().getJmbg().toString().length(); i++) {
//            if (!Character.isDigit(attendance.getChild().getJmbg().toString().charAt(i))) {
//                throw new Exception("JMBG does not contain just digits!");
//                
//            }
//         }


    }

}
