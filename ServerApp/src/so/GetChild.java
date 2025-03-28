/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Child;
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
public class GetChild extends AbstractSO {

    public GetChild() throws SQLException, Exception {
        super();
    }

    private Child child;

    public Child getChild() {
        return child;
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<DomainObject> domainObjects = broker.get((Child) object);
        List<Child> children = new ArrayList<>();
        for (DomainObject domainObject : domainObjects) {
            children.add((Child) domainObject);
        }
        if (!children.isEmpty()) {
            child = children.get(0);
        }
    }

    @Override
    protected void validation(Object object) throws Exception {
        if (!(object instanceof Child)) {
            throw new Exception("Object is not valid");
        }
//          Child child=(Child) object;
//         if(child.getJmbg()==0l){
//             throw new Exception("JMBG is empty!");
//        }
//         for (int i = 0; i < child.getJmbg().toString().length(); i++) {
//            if (!Character.isDigit(child.getJmbg().toString().charAt(i))) {
//                throw new Exception("JMBG does not contain just digits!");
//                
//            }
//         }

    }

}
