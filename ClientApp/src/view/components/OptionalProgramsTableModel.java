/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.components;

import domain.Child;
import domain.OptionalProgram;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class OptionalProgramsTableModel extends AbstractTableModel {

    private List<OptionalProgram> optionalPrograms;
    private List<OptionalProgram> editedOptionalPrograms=new ArrayList<>();
    private List<OptionalProgram> deletedOptionalPrograms=new ArrayList<>();
    String[]columns={"Naziv","Predvidjeni uzrast","Nivo tezine"};
    public OptionalProgramsTableModel(List<OptionalProgram>optionalPrograms){
        this.optionalPrograms=optionalPrograms;
    }

    @Override
    public int getRowCount() {
        return optionalPrograms.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       OptionalProgram optionalProgram=optionalPrograms.get(rowIndex);
        switch(columnIndex){
            case 0:return optionalProgram.getName();
            case 1:return optionalProgram.getAge();
            case 2:return optionalProgram.getDifficultyLevel();
            default:return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public OptionalProgram getOptionalProgram(int selectedRow) {
        return optionalPrograms.get(selectedRow);
    }

    public void refreshTable(OptionalProgram editedOptionalProgram) {
         for (int i = 0; i < optionalPrograms.size(); i++) {
            if(editedOptionalProgram.getId().equals(optionalPrograms.get(i).getId())){
                optionalPrograms.set(i, editedOptionalProgram);
                fireTableDataChanged();
            }
        }
         editedOptionalPrograms.add(editedOptionalProgram);
    }

    public void removeFromTable(OptionalProgram optionalProgram) {
        for (int i = 0; i < optionalPrograms.size(); i++) {
            if(optionalProgram.getId().equals(optionalPrograms.get(i).getId())){
                optionalPrograms.remove(i);
                fireTableDataChanged();
            }
        }
        deletedOptionalPrograms.add(optionalProgram);
    }

    public List<OptionalProgram> getEditedOptionalPrograms() {
        return editedOptionalPrograms;
    }

    public void setEditedOptionalPrograms(List<OptionalProgram> editedOptionalPrograms) {
        this.editedOptionalPrograms = editedOptionalPrograms;
    }

    public List<OptionalProgram> getDeletedOptionalPrograms() {
        return deletedOptionalPrograms;
    }

    public void setDeletedOptionalPrograms(List<OptionalProgram> deletedOptionalPrograms) {
        this.deletedOptionalPrograms = deletedOptionalPrograms;
    }

}
