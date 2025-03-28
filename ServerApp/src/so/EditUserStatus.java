/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.UserProfile;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PC
 */
public class EditUserStatus extends AbstractSO {

    public EditUserStatus() throws SQLException, Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<?> list = (List<?>) object;
        for (Object item : list) {
            broker.edit((UserProfile) item);
        }
    }

    @Override
    protected void validation(Object object) throws Exception {
        if (object instanceof List<?>) {
            List<?> list = (List<?>) object;
            for (Object item : list) {
                if (!(item instanceof UserProfile)) {
                    throw new Exception("Object is not valid.");
                }
            }
        }
            List<UserProfile> userprofiles = (List<UserProfile>) object;
            for (UserProfile user : userprofiles) {
                if (user.getUsername().isEmpty()) {
                    throw new Exception("Username is empty!");
                }
                if (user.getUserStatus() == null) {
                    throw new Exception("Status is empty!");
                }
                if (user.getUsername().length() > 30) {
                    throw new Exception("Username contains more then 30 characters!");
                }
            }

        }
    
    }
