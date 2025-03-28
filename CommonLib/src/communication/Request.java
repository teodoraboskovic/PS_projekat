/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Request implements Serializable{
    
    private Object argument;
    private OperationType operationType;

    public Request() {
    }

    public Request(Object argument, OperationType operationType) {
        this.argument = argument;
        this.operationType = operationType;
    }
    

    @Override
    public String toString() {
        return operationType+" "+argument+".";
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }
    
    
}
