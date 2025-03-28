/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import constants.ServerConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author PC
 */
public class DBConnection {

    private List<Connection> connectionPool;
    private static DBConnection instance;

    private DBConnection() throws SQLException, FileNotFoundException, IOException {
        connectionPool = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream("src\\config/dbconfig.properties"));
                String url = properties.getProperty(ServerConstants.DB_CONFIG_URL);
                String user = properties.getProperty(ServerConstants.DB_CONFIG_USERNAME);
                String password = properties.getProperty(ServerConstants.DB_CONFIG_PASSWORD);
                Connection connection = DriverManager.getConnection(url, user, password);
                System.out.println("Konekcija sa bazom podataka uspesno uspostavljena!");
                connection.setAutoCommit(false);
                connectionPool.add(connection);
            } catch (SQLException ex) {
                System.out.println("Greska! Konekcija sa bazom nije uspesno uspostavljena!\n" + ex.getMessage());
                ex.printStackTrace();
                throw ex;
            }
        }
    }

    public static DBConnection getInstance() throws SQLException, FileNotFoundException, IOException {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
     public synchronized Connection pull() throws Exception {//synchronized-ne dozvoljava da je dve niti pozovu u isto vreme, zakljucava objekat
        if (connectionPool.isEmpty()) {
            throw new Exception("There is no free connection");
        }
        Connection connection = connectionPool.get(0);
        connectionPool.remove(0);
        return connection;
    }
     public synchronized void push(Connection connection) {
        connectionPool.add(connection);
    }



}
