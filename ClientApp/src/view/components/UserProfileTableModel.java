/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.components;

import domain.Child;
import domain.UserProfile;
import domain.UserStatus;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class UserProfileTableModel extends AbstractTableModel {

    private List<UserProfile> userProfiles;
    String[]columns={"Ime","Prezime","Korisnicko ime","Status"};
    public UserProfileTableModel(List<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    @Override
    public int getRowCount() {
        return userProfiles.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       UserProfile userProfile=userProfiles.get(rowIndex);
        switch(columnIndex){
            case 0:return userProfile.getEmployer().getFirstname();
            case 1:return userProfile.getEmployer().getLastname();
            case 2:return userProfile.getUsername();
            case 3:return userProfile.getUserStatus();
            default:return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public UserProfile getUser(int selectedRow) {
        return userProfiles.get(selectedRow);
    }

    public void editTable(Long userId, String status) {
        for (UserProfile userProfile : userProfiles) {
            if(userProfile.getUserId()==userId){
                userProfile.setUserStatus(UserStatus.valueOf(status));
                fireTableDataChanged();
            }
        }
    }

    public List<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(List<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

}
