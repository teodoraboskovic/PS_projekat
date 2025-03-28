/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;
import java.io.Serializable;
    import java.util.List;


/**
 *
 * @author PC
 * @param <T>
 */
public class EditAndDeleteList <T extends DomainObject> implements Serializable{

    private List<T> editList;
    private List<T> deleteList;

    // Constructor
    public EditAndDeleteList(List<T> editList, List<T> deleteList) {
        this.editList = editList;
        this.deleteList = deleteList;
    }

    // Getters and Setters
    public List<T> getEditList() {
        return editList;
    }

    public void setEditList(List<T> editList) {
        this.editList = editList;
    }

    public List<T> getDeleteList() {
        return deleteList;
    }

    public void setDeleteList(List<T> deleteList) {
        this.deleteList = deleteList;
    }
}
