/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import repository.DBBroker;
import repository.DBConnection;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public abstract class AbstractSO {

    protected DBBroker broker;
    
    public AbstractSO() throws SQLException, Exception {
        broker = new DBBroker(DBConnection.getInstance().pull());
    }

    public void execute(Object object) throws Exception {
        try {
            validation(object);
            executeOperation(object);
            commit();
        } catch (SQLException ex) {
            rollback();
            throw ex;
        }
        finally{
            DBConnection.getInstance().push(broker.getConnection());
        }
    }

    private void commit() throws SQLException {
        broker.getConnection().commit();
    }

    private void rollback() throws SQLException {
        broker.getConnection().rollback();
    }

    protected abstract void executeOperation(Object object) throws Exception;

    protected abstract void validation(Object object) throws Exception;
    

}
