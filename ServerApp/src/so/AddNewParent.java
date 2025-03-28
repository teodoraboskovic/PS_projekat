/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import repository.DBBroker;
import repository.DBConnection;
import domain.Employer;
import domain.Parent;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class AddNewParent extends AbstractSO {

    public AddNewParent() throws SQLException, Exception {
        super();
    }
    

    @Override
    protected void executeOperation(Object object) throws Exception {
         broker.add((Parent) object);
    }

    @Override
    protected void validation(Object object) throws Exception {
        if (!(object instanceof Parent)) {
            throw new Exception("Object is not valid");
        }
        Parent parent=(Parent) object;
        if(parent.getAdress().isEmpty()){
            throw new Exception("Adress is empty!");
        }
        if(parent.getFirstname().isEmpty()){
            throw new Exception("Firstname is empty!");
        }
        if(parent.getLastname().isEmpty()){
            throw new Exception("Lastname is empty!");
        }
        if(parent.getPhoneNumber()==null){
            throw new Exception("Phone number is empty!");
        }
        if(parent.getJmbg().toString().isEmpty()){
            throw new Exception("JMBG is empty!");
        }
        if (parent.getFirstname().length() > 30) {
            throw new Exception("Firstname contains more then 30 characters!");
        }
        if (parent.getLastname().length() > 30) {
            throw new Exception("Lastname contains more then 30 characters");
        }
        if(parent.getAdress().length()>40){
            throw new Exception("Adress contains more then 40 characters");
        }
        for (int i = 0; i < parent.getJmbg().toString().length(); i++) {
            if (!Character.isDigit(parent.getJmbg().toString().charAt(i))) {
                throw new Exception("JMBG does not contain just digits!");
            }
        }
        for (int i = 0; i < parent.getPhoneNumber().toString().length(); i++) {
            if (!Character.isDigit(parent.getPhoneNumber().toString().charAt(i))) {
                throw new Exception("Phone number does not contain just digits!");
            }
        }
        for (int i = 0; i < parent.getFirstname().length(); i++) {
            if (!Character.isLetter(parent.getFirstname().charAt(i)) && parent.getFirstname().charAt(i) != ' ') {
                throw new Exception("Firstname does not contain just letters!");
            }
        }
        for (int i = 0; i < parent.getLastname().length(); i++) {
            if (!Character.isLetter(parent.getLastname().charAt(i)) && parent.getLastname().charAt(i) != ' ') {
                throw new Exception("Lastname does not contain just letters!");
            }
        }
    }

}
