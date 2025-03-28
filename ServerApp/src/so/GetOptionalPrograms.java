/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.OptionalProgram;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class GetOptionalPrograms extends AbstractSO {

    public GetOptionalPrograms() throws SQLException, Exception {
        super();
    }

    private List<OptionalProgram> optionalPrograms;

    public List<OptionalProgram> getOptionalPrograms() {
        return optionalPrograms;
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<DomainObject>domainObjects=broker.get((OptionalProgram)object);
        List<OptionalProgram>op=new ArrayList<>();
        for (DomainObject domainObject : domainObjects) {
            op.add((OptionalProgram)domainObject);
        }
        optionalPrograms=op;
    }

    @Override
    protected void validation(Object object) throws Exception {
         if (!(object instanceof OptionalProgram)) {
            throw new Exception("Object is not valid");
        }
//          OptionalProgram optionalProgram=(OptionalProgram) object;
//         if (optionalProgram.getName().isEmpty()) {
//            throw new Exception("Name is empty!");
//        }
//        if(optionalProgram.getName().length()>30){
//            throw new Exception("Name contains more then 30 characters!");
//        }
    }

}
