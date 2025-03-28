/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Parent;
import domain.UserProfile;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author PC
 */
public class GetParent extends AbstractSO {

    public GetParent() throws SQLException, Exception {
        super();
    }

    private Parent parent;

    public Parent getParent() {
        return parent;
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<DomainObject> domainObjects = broker.get((Parent) object);
        List<Parent> parents = new ArrayList<>();
        for (DomainObject domainObject : domainObjects) {
            parents.add((Parent) domainObject);
        }
        if (!parents.isEmpty()) {
            parent = parents.get(0);
        }
    }

    @Override
    protected void validation(Object object) throws Exception {
        if (!(object instanceof Parent)) {
            throw new Exception("Object is not valid");
        }

//         Parent parent=(Parent) object;
//         if(parent.getJmbg()==0l){
//             throw new Exception("JMBG is empty!");
//        }
//         for (int i = 0; i < parent.getJmbg().toString().length(); i++) {
//            if (!Character.isDigit(parent.getJmbg().toString().charAt(i))) {
//                throw new Exception("JMBG does not contain just digits!");
//                
//            }
//         }
    }

}
