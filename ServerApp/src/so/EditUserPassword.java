/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Child;
import domain.Employer;
import domain.OptionalProgram;
import domain.Parent;
import domain.UserProfile;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class EditUserPassword extends AbstractSO {

    public EditUserPassword() throws SQLException, Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        broker.edit((UserProfile) object);
    }

    @Override
    protected void validation(Object object) throws Exception {
        if (!(object instanceof UserProfile)) {
            throw new Exception("Object is not valid");
        }
        UserProfile userProfile=(UserProfile) object;
        if(userProfile.getPassword().isEmpty()){
            throw new Exception("Password is empty!");
        }
        if(userProfile.getPassword().equalsIgnoreCase(userProfile.getUsername()) || userProfile.getPassword().equalsIgnoreCase(userProfile.getEmployer().getFirstname())|| userProfile.getPassword().equalsIgnoreCase(userProfile.getEmployer().getLastname())){
            throw new Exception("Password is weak!");
        }

    }

}
