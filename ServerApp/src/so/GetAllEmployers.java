/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Employer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class GetAllEmployers extends AbstractSO{

    public GetAllEmployers() throws SQLException, Exception {
        super();
    }
    List<Employer>employers;
    public List<Employer> getEmployers(){
        return employers;
    }
    @Override
    protected void executeOperation(Object object) throws Exception {
        employers=new ArrayList<>();
        List<DomainObject>domainObjects=broker.get((Employer)object);
        for (DomainObject domainObject : domainObjects) {
            employers.add((Employer)domainObject);
        }
    }

    @Override
    protected void validation(Object object) throws Exception {
        if(!(object instanceof Employer)){
            throw new Exception("Object is not valid");
        }
    }
    
}
