/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Child;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class EditChild extends AbstractSO{

    public EditChild() throws SQLException, Exception {
        super();
    }
    

    @Override
    protected void executeOperation(Object object) throws Exception {
        broker.edit((Child)object);
    }

    @Override
    protected void validation(Object object) throws Exception {
        if (!(object instanceof Child)) {
            throw new Exception("Object is not valid");
        }
        Child child = (Child) object;
        if (child.getBirthday() == null) {
            throw new Exception("Birthday is not selected!");
        }
        if (child.getFirstname().isEmpty()) {
            throw new Exception("Firstname is empty!");
        }
        if (child.getLastname().isEmpty()) {
            throw new Exception("Lastname is empty!");
        }
        if (child.getParent() == null) {
            throw new Exception("Parent is not selected!");
        }
        if(child.getJmbg().toString().isEmpty()){
            throw new Exception("JMBG is empty!");
        }
        if (child.getFirstname().length() > 30) {
            throw new Exception("Firstname contains more then 30 characters!");
        }
        if (child.getLastname().length() > 30) {
            throw new Exception("Lastname contains more then 30 characters");
        }
        for (int i = 0; i < child.getJmbg().toString().length(); i++) {
            if (!Character.isDigit(child.getJmbg().toString().charAt(i))) {
                throw new Exception("JMBG does not contain just digits!");
            }
        }
        for (int i = 0; i < child.getFirstname().length(); i++) {
            if (!Character.isLetter(child.getFirstname().charAt(i)) && child.getFirstname().charAt(i) != ' ') {
                throw new Exception("Firstname does not contain just letters!");
            }
        }
        for (int i = 0; i < child.getLastname().length(); i++) {
            if (!Character.isLetter(child.getLastname().charAt(i)) && child.getLastname().charAt(i) != ' ') {
                throw new Exception("Lastname does not contain just letters!");
            }
        }
    }
    
}
