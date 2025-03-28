/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import repository.DBBroker;
import repository.DBConnection;
import domain.Employer;
import domain.OptionalProgram;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class AddNewOptionalProgram extends AbstractSO {

    public AddNewOptionalProgram() throws SQLException, Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        broker.add((OptionalProgram) object);
    }

    @Override
    protected void validation(Object object) throws Exception {
        if (!(object instanceof OptionalProgram)) {
            throw new Exception("Object is not valid");
        }
        OptionalProgram optionalProgram=(OptionalProgram) object;
        if(optionalProgram.getAge().isEmpty()){
            throw new Exception("Age is not selected!");
        }
        if(optionalProgram.getName().isEmpty()){
            throw new Exception("Name is empty!");
        }
        if (optionalProgram.getName().length() > 30) {
           throw new Exception("Name contains more then 30 characters!");
        }
    }

}
