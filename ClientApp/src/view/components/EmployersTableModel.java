/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.components;

import domain.Child;
import domain.Employer;
import domain.OptionalProgram;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class EmployersTableModel extends AbstractTableModel {

    private List<Employer> employers;
    private List<Employer> editedEmployers=new ArrayList<>();
    private List<Employer> deletedEmployers=new ArrayList<>();
    String[]columns={"Ime","Prezime","Adresa","Kontakt telefon","Stepen strucne spreme","Izborni program"};
    public EmployersTableModel(List<Employer> employers) {
        this.employers = employers;
    }

    @Override
    public int getRowCount() {
        return employers.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Employer employer=employers.get(rowIndex);
        switch(columnIndex){
            case 0:return employer.getFirstname();
            case 1:return employer.getLastname();
            case 2:return employer.getAdress();
            case 3:return employer.getPhoneNumber();
            case 4:return employer.getSss();
            case 5:return employer.getOptionalProgram().getName();
            default:return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public Employer getEmployer(int selectedRow) {
        return employers.get(selectedRow);
    }

    public void refreshTable(Employer editedEmployer) {
        for (int i = 0; i < employers.size(); i++) {
            if(editedEmployer.getId().equals(employers.get(i).getId())){
                employers.set(i, editedEmployer);
                fireTableDataChanged();
            }
        }
        editedEmployers.add(editedEmployer);
    }

    public void removeFromTable(Employer employer) {
         for (int i = 0; i < employers.size(); i++) {
            if(employer.getId().equals(employers.get(i).getId())){
                employers.remove(i);
                fireTableDataChanged();
            }
        }
         deletedEmployers.add(employer);
    }

    public List<Employer> getEditedEmployers() {
        return editedEmployers;
    }

    public void setEditedEmployers(List<Employer> editedEmployers) {
        this.editedEmployers = editedEmployers;
    }

    public List<Employer> getDeletedEmployers() {
        return deletedEmployers;
    }

    public void setDeletedEmployers(List<Employer> deletedEmployers) {
        this.deletedEmployers = deletedEmployers;
    }

    

}
