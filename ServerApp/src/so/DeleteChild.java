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
public class DeleteChild extends AbstractSO{

    public DeleteChild() throws SQLException, Exception {
        super();
    }
    

    @Override
    protected void executeOperation(Object object) throws Exception {
        broker.delete((Child)object);
    }

    @Override
    protected void validation(Object object) throws Exception {
    }
    
}
