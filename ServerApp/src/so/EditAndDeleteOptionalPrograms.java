/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Attendance;
import domain.Child;
import domain.EditAndDeleteList;
import domain.OptionalProgram;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PC
 */
public class EditAndDeleteOptionalPrograms extends AbstractSO {

    public EditAndDeleteOptionalPrograms() throws SQLException, Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        EditAndDeleteList editAndDeleteList = (EditAndDeleteList) object;
        List<OptionalProgram> editedOptionalPrograms = editAndDeleteList.getEditList();
        List<OptionalProgram> deletedOptionalPrograms = editAndDeleteList.getDeleteList();
        for (OptionalProgram editedOptionalProgram : editedOptionalPrograms) {
            broker.edit(editedOptionalProgram);
        }
        for (OptionalProgram deletedOptionalProgram : deletedOptionalPrograms) {
            broker.delete(deletedOptionalProgram);
        }
    }

    @Override
    protected void validation(Object object) throws Exception {
        if (!(object instanceof EditAndDeleteList)) {
            throw new Exception("Object is not valid");
        }
         EditAndDeleteList editAndDeleteList = (EditAndDeleteList) object;
        List<OptionalProgram> editedOptionalPrograms = editAndDeleteList.getEditList();
        List<OptionalProgram> deletedOptionalPrograms = editAndDeleteList.getDeleteList();
        
        for (OptionalProgram optionalProgram : editedOptionalPrograms) {
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

}
