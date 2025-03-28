/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Employer;
import domain.Parent;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class DeleteEmployer extends AbstractSO{

    public DeleteEmployer() throws SQLException, Exception {
        super();
    }
    

    @Override
    protected void executeOperation(Object object) throws Exception {
        broker.delete((Employer)object);
    }

    @Override
    protected void validation(Object object) throws Exception {
    }
    
}
