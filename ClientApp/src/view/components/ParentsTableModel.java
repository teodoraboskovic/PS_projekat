/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.components;

import domain.Child;
import domain.Parent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class ParentsTableModel extends AbstractTableModel {

    private List<Parent> parents;
    private List<Parent>deletedParents=new ArrayList<>();
    private List<Parent>editedParents=new ArrayList<>();
    String[]columns={"Ime","Prezime","JMBG","Adresa","Kontakt telefon"};
    public ParentsTableModel(List<Parent> parents) {
        this.parents = parents;
    }

    @Override
    public int getRowCount() {
        return parents.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Parent parent=parents.get(rowIndex);
        switch(columnIndex){
            case 0:return parent.getFirstname();
            case 1:return parent.getLastname();
            case 2:return parent.getJmbg();
            case 3:return parent.getAdress();
            case 4:return parent.getPhoneNumber();
            default:return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public Parent getParent(int selectedRow) {
        return parents.get(selectedRow);
    }
    

    public void refreshTable(Parent editedParent) {
        for (int i = 0; i < parents.size(); i++) {
            if(editedParent.getId().equals(parents.get(i).getId())){
                parents.set(i, editedParent);
                fireTableDataChanged();
            }
        }
        editedParents.add(editedParent);
    }

    public void removeFromTable(Parent parent) {
        for (int i = 0; i < parents.size(); i++) {
            if(parent.getId().equals(parents.get(i).getId())){
                parents.remove(i);
                fireTableDataChanged();
            }
        }
        deletedParents.add(parent);
    }

    public List<Parent> getDeletedParents() {
        return deletedParents;
    }

    public void setDeletedParents(List<Parent> deletedParents) {
        this.deletedParents = deletedParents;
    }

    public List<Parent> getEditedParents() {
        return editedParents;
    }

    public void setEditedParents(List<Parent> editedParents) {
        this.editedParents = editedParents;
    }

}
