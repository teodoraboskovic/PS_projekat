/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.components;

import domain.Child;
import domain.NumberOfChildrenByOptionalPrograms;
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
public class NumberOfChildrenTableModel extends AbstractTableModel {

    private List<NumberOfChildrenByOptionalPrograms> numOfChildren=new ArrayList<>();
    String[] columns = {"Izborni program","Broj dece"};

    public NumberOfChildrenTableModel(List<NumberOfChildrenByOptionalPrograms> numOfChildren) {
        this.numOfChildren=numOfChildren;
    }

    @Override
    public int getRowCount() {
        return numOfChildren.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NumberOfChildrenByOptionalPrograms numOfChildrenByOptionalPrograms = this.numOfChildren.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return numOfChildrenByOptionalPrograms.getAttendance().getOptionalProgram();
            case 1:
                return numOfChildrenByOptionalPrograms.getNumberOfChildren();
            default:
                return "n/a";
        }

    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    

}
