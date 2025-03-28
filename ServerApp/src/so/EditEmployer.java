/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Child;
import domain.Employer;
import domain.Parent;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class EditEmployer extends AbstractSO {

    public EditEmployer() throws SQLException, Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        broker.edit((Employer) object);
    }

    @Override
    protected void validation(Object object) throws Exception {
        if (!(object instanceof Employer)) {
            throw new Exception("Object is not valid");
        }
        Employer employer = (Employer) object;
        if (employer.getAdress().isEmpty()) {
            throw new Exception("Adress is empty!");
        }
        if (employer.getFirstname().isEmpty()) {
            throw new Exception("Firstname is empty!");
        }
        if (employer.getLastname().isEmpty()) {
            throw new Exception("Lastname is empty!");
        }
        if (employer.getPhoneNumber() == null) {
            throw new Exception("Phone number is empty!");
        }
        if (employer.getFirstname().length() > 30) {
            throw new Exception("Firstname contains more then 30 characters!");
        }
        if (employer.getLastname().length() > 30) {
            throw new Exception("Lastname contains more then 30 characters!");
        }
        if (employer.getAdress().length() > 40) {
            throw new Exception("Adress contains more then 40 characters!");
        }

        for (int i = 0; i < employer.getFirstname().length(); i++) {
            if (!Character.isLetter(employer.getFirstname().charAt(i)) && employer.getFirstname().charAt(i) != ' ') {
                throw new Exception("Firstname does not contain just letters!");
            }
        }
        for (int i = 0; i < employer.getLastname().length(); i++) {
            if (!Character.isLetter(employer.getLastname().charAt(i)) && employer.getLastname().charAt(i) != ' ') {
                throw new Exception("Lastname does not contain just letters!");
            }
        }

    }

}
