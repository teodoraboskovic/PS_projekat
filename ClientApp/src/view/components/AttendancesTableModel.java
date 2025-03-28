/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.components;

import domain.Attendance;
import domain.Child;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class AttendancesTableModel extends AbstractTableModel {

    private List<Attendance> attendances;
    String[] columns = {"Ime", "Prezime", "Jmbg", "Izborni program", "Datum upisa", "Datum ispisa"};
    private List<Attendance> editedAttendances = new ArrayList<>();
    private List<Attendance> deletedAttendances = new ArrayList<>();

    public AttendancesTableModel(List<Attendance> attendances) {
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
        Attendance attendance = attendances.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return attendance.getChild().getFirstname();
            case 1:
                return attendance.getChild().getLastname();
            case 2:
                return attendance.getChild().getJmbg();
            case 3:
                return attendance.getOptionalProgram().getName();
            case 4:
                if (attendance.getStartDate() instanceof Date) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    return sdf.format((Date) attendance.getStartDate());
                } else {
                    return attendance.getStartDate();
                }
            case 5:
                if (attendance.getEndDate() instanceof Date) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    return sdf.format((Date) attendance.getEndDate());
                } else {
                    return attendance.getEndDate();
                }

            default:
                return "n/a";
        }

    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public Attendance getAttendance(int selectedRow) {
        return attendances.get(selectedRow);
    }

    public void removeFromTable(Attendance attendance) {
        for (int i = 0; i < attendances.size(); i++) {
            if (attendance.getChild().getId().equals(attendances.get(i).getChild().getId())
                    && attendance.getOptionalProgram().getId().equals(attendances.get(i).getOptionalProgram().getId()))  {
                attendances.remove(i);
                fireTableDataChanged();
            }
        }
        deletedAttendances.add(attendance);
    }
    public void refreshTable(Attendance editedAttendance, Attendance attendance) {
        for (int i = 0; i < attendances.size(); i++) {
            if (attendance.getChild().getId().equals(attendances.get(i).getChild().getId())
                    && attendance.getOptionalProgram().getId().equals(attendances.get(i).getOptionalProgram().getId())) {
                editedAttendance.setOldAttendance(attendance);
                attendances.set(i, editedAttendance);
                fireTableDataChanged();
            }else{
//                System.out.println("nesto ne valja");
            }
        }
        editedAttendances.add(editedAttendance);
    }

    public List<Attendance> getEditedAttendance() {
        return editedAttendances;
    }

    public void setEditedAttendance(List<Attendance> editedAttendance) {
        this.editedAttendances = editedAttendance;
    }

    public List<Attendance> getDeletedAttendance() {
        return deletedAttendances;
    }

    public void setDeletedAttendance(List<Attendance> deletedAttendance) {
        this.deletedAttendances = deletedAttendance;
    }

   

}
