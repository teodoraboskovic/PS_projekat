/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.components;

import domain.Child;
import view.form.util.Mode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class ChildrenTableModel extends AbstractTableModel {

    private List<Child> children;
    String[] columns = {"Ime", "Prezime", "JMBG", "Datum rodjenja", "Ime i prezime roditelja"};
    private List<Child> editedChildren = new ArrayList<>();
    private List<Child> deletedChildren = new ArrayList<>();

    public ChildrenTableModel(List<Child> children) {
        this.children = children;
    }

    @Override
    public int getRowCount() {
        return children.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Child child = children.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return child.getFirstname();
            case 1:
                return child.getLastname();
            case 2:
                return child.getJmbg();
            case 3:
                if (child.getBirthday() instanceof Date) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    return sdf.format((Date) child.getBirthday());
                } else {
                    return child.getBirthday();
                }
            case 4:
                return child.getParent().getFirstname() + " " + child.getParent().getLastname();

            default:
                return "n/a";
        }

    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public Child getChild(int selectedRow) {
            return children.get(selectedRow);
       
    }

    public void refreshTable(Child editedChild) {
        for (int i = 0; i < children.size(); i++) {
            if (editedChild.getId().equals(children.get(i).getId())) {
                children.set(i, editedChild);

                fireTableDataChanged();

            }
        }
        editedChildren.add(editedChild);
    }

    public void removeFromTable(Child child) {
        for (int i = 0; i < children.size(); i++) {
            if (child.getId().equals(children.get(i).getId())) {
                children.remove(i);
                fireTableDataChanged();
            }
        }
        deletedChildren.add(child);
    }

    public List<Child> getEditedChildren() {
        return editedChildren;
    }

    public void setEditedChildren(List<Child> editedChildren) {
        this.editedChildren = editedChildren;
    }

    public List<Child> getDeletedChildren() {
        return deletedChildren;
    }

    public void setDeletedChildren(List<Child> deletedChildren) {
        this.deletedChildren = deletedChildren;
    }

}
