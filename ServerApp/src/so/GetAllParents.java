/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import repository.DBBroker;
import repository.DBConnection;
import domain.Child;
import domain.DomainObject;
import domain.Parent;
import domain.UserProfile;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class GetAllParents extends AbstractSO {

    public GetAllParents() throws SQLException, Exception {
        super();
    }

    private List<Parent> parents;

    public List<Parent> getParents() {
        return parents;
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        parents=new ArrayList<>();
        List<DomainObject> domainObjects = broker.get((Parent) object);
        for (DomainObject obj : domainObjects) {
            parents.add((Parent) obj);
        }
    }

    @Override
    protected void validation(Object object) throws Exception {
        if (!(object instanceof Parent)) {
            throw new Exception("Object is not valid");
        }
        
    }

}
