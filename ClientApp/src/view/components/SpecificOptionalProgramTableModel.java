/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.components;

import domain.Attendance;
import domain.Child;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class SpecificOptionalProgramTableModel extends AbstractTableModel {

    private List<Attendance> attendances;
    String[]columns={"Ime","Prezime","JMBG","Datum rodjenja","Datum upisa","Datum ispisa"};
    public SpecificOptionalProgramTableModel(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    @Override
    public int getRowCount() {
        return attendances.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Attendance attendance=attendances.get(rowIndex);
        switch(columnIndex){
            case 0:return attendance.getChild().getFirstname();
            case 1:return attendance.getChild().getLastname();
            case 2:return attendance.getChild().getJmbg();
            case 3:return attendance.getChild().getBirthday();
            case 4:return attendance.getStartDate();
            case 5:return attendance.getEndDate();
            default:return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public void refreschTable(List<Attendance> attendances) {
        this.attendances=attendances;
        fireTableDataChanged();
    }

    public Attendance getAttendance(int selectedRow) {
        return attendances.get(selectedRow);
    }


}
