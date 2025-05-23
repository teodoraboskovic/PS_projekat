/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package communication;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public enum OperationType implements Serializable {
    LOGIN, ADD_NEW_CHILD, ADD_NEW_PARENT, ADD_NEW_ATTENDANCE, ADD_NEW_OPTIONAL_PROGRAM, 
    ADD_NEW_WORKER, GET_ALL_PARENTS, GET_ALL_OPTIONAL_PROGRAMS, SEARCH_CHILDREN, 
    SEARCH_ATTENDANCE, EDIT_ATTENDANCE, EDIT_OPTINAL_PROGRAM, DELETE_OPTINAL_PROGRAM,
    GET_PARENT,GET_ALL_CHILDREN,GET_ALL_USERS,EDIT_USER_STATUS, ADD_NEW_PARENT_CHILD,
    GET_ATTENDANCES, GET_ATTENDANCES_NULL_END_DATE,GET_ATTENDANCES_NOT_NULL_END_DATE,GET_ALL_EMPLOYERS,
    EDIT_CHILD,DELETE_CHILD,EDIT_PARENT,DELETE_PARENT,EDIT_EMPLOYER,DELETE_EMPLOYER,EDIT_OPTIONAL_PROGRAM,
    DELETE_OPTIONAL_PROGRAM, EDIT_USER_PASSWORD, QUIT_ATTENDANCE,GET_CHILD,GET_ALL_ATTENDANCES,
    GET_SEARCHED_ATTENDANCES,DELETE_ATTENDANCE,GET_EMPLOYERS,GET_OPTIONAL_PROGRAMS,GET_ATTENDANCE,
    EDIT_AND_DELETE_ATTENDANCES,EDIT_AND_DELETE_CHILDREN,EDIT_AND_DELETE_EMPLOYERS,
    EDIT_AND_DELETE_OPTIONAL_PROGRAMS,EDIT_AND_DELETE_PARENTS,LOGOUT,LOGOUT_ALL
}
