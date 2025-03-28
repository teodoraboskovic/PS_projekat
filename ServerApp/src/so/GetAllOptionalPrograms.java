/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import repository.DBBroker;
import repository.DBConnection;
import domain.DomainObject;
import domain.Employer;
import domain.OptionalProgram;
import domain.Parent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class GetAllOptionalPrograms extends AbstractSO {

    public GetAllOptionalPrograms() throws SQLException, Exception {
        super();
    }

    private List<OptionalProgram> optionalPrograms;

    public List<OptionalProgram> getOptionalPrograms() {
        return optionalPrograms;
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        optionalPrograms = new ArrayList<>();
        List<DomainObject> domainObjects = broker.get((OptionalProgram) object);
        for (DomainObject domainObject : domainObjects) {
            optionalPrograms.add((OptionalProgram) domainObject);
        }
    }

    @Override
    protected void validation(Object object) throws Exception {
        if (!(object instanceof OptionalProgram)) {
            throw new Exception("Object is not valid");
        }
    }

}
