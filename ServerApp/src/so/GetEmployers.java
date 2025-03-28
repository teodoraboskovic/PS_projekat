/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Attendance;
import domain.DomainObject;
import domain.Employer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class GetEmployers extends AbstractSO {

    public GetEmployers() throws SQLException, Exception {
        super();
    }

    private List<Employer> employers;

    public List<Employer> getEmployers() {
        return employers;
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<DomainObject>domainObjects=broker.get((Employer)object);
        List<Employer>em=new ArrayList<>();
         for (DomainObject domainObject : domainObjects) {
            em.add((Employer)domainObject);
        }
         employers=em;
    }

    @Override
    protected void validation(Object object) throws Exception {
         if (!(object instanceof Employer)) {
            throw new Exception("Object is not valid");
        }
//          Employer employer=(Employer) object;
//         if (employer.getLastname().isEmpty()) {
//            throw new Exception("Lastname is empty!");
//        }
//        if(employer.getLastname().length()>30){
//            throw new Exception("Lastname contains more then 30 characters!");
//        }
//        for (int i = 0; i < employer.getLastname().length(); i++) {
//            if (!Character.isLetter(employer.getLastname().charAt(i)) && employer.getLastname().charAt(i) != ' ') {
//                throw new Exception("Lastname does not contain just letters!");
//            }
//        }
    }

}
