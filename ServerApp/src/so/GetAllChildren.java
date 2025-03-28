/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Child;
import domain.DomainObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class GetAllChildren extends AbstractSO{

    public GetAllChildren() throws SQLException, Exception {
        super();
    }
    
    List<Child>children;

    public List<Child> getChildren() {
        return children;
    }
    

    @Override
    protected void executeOperation(Object object) throws Exception {
        children=new ArrayList<>();
        List<DomainObject>domainObjects=broker.get((Child)object);
        for (DomainObject domainObject : domainObjects) {
            children.add((Child)domainObject);
        }
    }

    @Override
    protected void validation(Object object) throws Exception {
        if(!(object instanceof Child)){
            throw new Exception("Object is not valid");
        }
    }
    
}
