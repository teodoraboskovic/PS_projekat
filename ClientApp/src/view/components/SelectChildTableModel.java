/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.components;

import domain.Child;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class SelectChildTableModel extends AbstractTableModel {

    private List<Child> children;
    String[] columns = {"Ime", "Prezime", "JMBG"};

    public SelectChildTableModel(List<Child> children) {
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

}
