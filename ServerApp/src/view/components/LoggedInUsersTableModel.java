/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.components;

import domain.Child;
import domain.UserProfile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class LoggedInUsersTableModel extends AbstractTableModel {

    private List<UserProfile> users=new ArrayList<>();
    String[] columns = {"Korisnicko ime"};

    public LoggedInUsersTableModel(List<UserProfile> users) {
        this.users = users;
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        UserProfile user = users.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return user.getUsername();
//            case 1:
//                return user.getEmployer().getFirstname();
//            case 2:
//                return user.getEmployer().getLastname();
            default:
                return "n/a";
        }

    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    

}
