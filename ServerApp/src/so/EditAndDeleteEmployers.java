/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Attendance;
import domain.Child;
import domain.EditAndDeleteList;
import domain.Employer;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PC
 */
public class EditAndDeleteEmployers extends AbstractSO {

    public EditAndDeleteEmployers() throws SQLException, Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        EditAndDeleteList editAndDeleteList = (EditAndDeleteList) object;
        List<Employer> editedEmployers = editAndDeleteList.getEditList();
        List<Employer> deletedEmployers = editAndDeleteList.getDeleteList();
        for (Employer editedEmployer : editedEmployers) {
            broker.edit(editedEmployer);
        }
        for (Employer deletedEmployer : deletedEmployers) {
            broker.delete(deletedEmployer);
        }
    }

    @Override
    protected void validation(Object object) throws Exception {
        if (!(object instanceof EditAndDeleteList)) {
            throw new Exception("Object is not valid");
        }
        EditAndDeleteList editAndDeleteList = (EditAndDeleteList) object;
        List<Employer> editedEmployers = editAndDeleteList.getEditList();
        List<Employer> deletedEmployers = editAndDeleteList.getDeleteList();

        for (Employer employer : editedEmployers) {
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

}
