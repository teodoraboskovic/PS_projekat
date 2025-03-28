/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import repository.DBBroker;
import repository.DBConnection;
import domain.DomainObject;
import domain.Employer;
import domain.UserProfile;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PC
 */
public class Login extends AbstractSO {

    public Login() throws SQLException, Exception {
        super();
    }

    private UserProfile user;

    public UserProfile getUser() {
        return user;
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<DomainObject> domainObjects = broker.get((UserProfile) object);
        if (!domainObjects.isEmpty()) {
            user = (UserProfile) domainObjects.get(0);
        }else{
            throw new Exception("User does not exist");
        }
    }

    @Override
    protected void validation(Object object) throws Exception {
        if (!(object instanceof UserProfile)) {
            throw new Exception("Object is not valid");
        }
        UserProfile user = (UserProfile) object;
        if (user.getUsername().isEmpty()) {
            throw new Exception("Username is empty!");
        }
        if (user.getPassword().isEmpty()) {
            throw new Exception("Password is empty!");
        }
        if (user.getUsername().length() > 30) {
            throw new Exception("Username contains more then 30 characters!");
        }
        if (user.getPassword().length() > 30) {
            throw new Exception("Password contains more then 30 characters!");
        }

    }

}
