/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.UserProfile;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class GetAllUsers extends AbstractSO {

    public GetAllUsers() throws SQLException, Exception {
        super();
    }

    private List<UserProfile> users;

    public List<UserProfile> getUsers() {
        return users;
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<DomainObject>domainObjects= broker.get((UserProfile)object);
        List<UserProfile>userProfiles=new ArrayList<>();
        for (DomainObject domainObject : domainObjects) {
            userProfiles.add((UserProfile)domainObject);
        }
        users = userProfiles;
    }

    @Override
    protected void validation(Object object) throws Exception {
        if (!(object instanceof UserProfile)) {
            throw new Exception("Object is not valid");
        }
    }
}
