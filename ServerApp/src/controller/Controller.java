/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import repository.DBBroker;
import communication.OperationType;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Attendance;
import domain.Child;
import domain.EditAndDeleteList;
import domain.Employer;
import domain.OptionalProgram;
import domain.Parent;
import domain.UserProfile;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.AddNewAttendance;
import so.AddNewChild;
import so.AddNewEmployer;
import so.AddNewOptionalProgram;
import so.AddNewParent;
import so.AddNewParentChild;
import so.DeleteAttendance;
import so.DeleteChild;
import so.DeleteEmployer;
import so.DeleteOptionalProgram;
import so.DeleteParent;
import so.EditAndDeleteAttendances;
import so.EditAndDeleteChildren;
import so.EditAndDeleteEmployers;
import so.EditAndDeleteOptionalPrograms;
import so.EditAndDeleteParents;
import so.EditAttendance;
import so.EditChild;
import so.EditEmployer;
import so.EditOptionalProgram;
import so.EditParent;
import so.EditUserPassword;
import so.EditUserStatus;
import so.GetAllAttendances;
import so.GetAllChildren;
import so.GetAllEmployers;
import so.GetAllOptionalPrograms;
import so.GetAllParents;
import so.GetAttendancesByOptionalProgram;
import so.GetAttendancesByOptionalProgramNotNullEndDate;
import so.GetAttendancesByOptionalProgramNullEndDate;
import so.GetParent;
import so.GetAllUsers;
import so.GetAttendance;
import so.GetChild;
import so.GetEmployers;
import so.GetOptionalPrograms;
import so.GetSearchedAttendances;
import so.Login;
import so.QuitAttendance;
import thread.ClientThread;

/**
 *
 * @author PC
 */
public class Controller {
    

    public UserProfile login(UserProfile user) throws Exception {
        Login login = new Login();
        login.execute(user);
        return login.getUser();
    }

    public void addNewParent(Parent parent) throws Exception {
        AddNewParent addNewParent = new AddNewParent();
        addNewParent.execute(parent);
    }

    public void addNewChild(Child child) throws Exception {
        AddNewChild addNewChild = new AddNewChild();
        addNewChild.execute(child);
    }

    public List<Parent> getAllParents() throws Exception {
        GetAllParents getAllParents = new GetAllParents();
        getAllParents.execute(new Parent());
        return getAllParents.getParents();
    }

    public List<OptionalProgram> getAllOptionalPrograms() throws Exception {
        GetAllOptionalPrograms getAllOptionalPrograms = new GetAllOptionalPrograms();
        getAllOptionalPrograms.execute(new OptionalProgram());
        return getAllOptionalPrograms.getOptionalPrograms();
    }

    public void addNewEmployer(Employer employer) throws Exception {
        AddNewEmployer addNewEmployer = new AddNewEmployer();
        addNewEmployer.execute(employer);
    }

    public void addNewOptionalProgram(OptionalProgram optionalProgram) throws Exception {
        AddNewOptionalProgram addNewOptionalProgram = new AddNewOptionalProgram();
        addNewOptionalProgram.execute(optionalProgram);
    }

    public Parent getParent(Parent parent) throws Exception {
        GetParent getParent = new GetParent();
        getParent.execute(parent);
        return getParent.getParent();
    }

    public List<Child> getAllChildren() throws Exception {
        GetAllChildren getAllChildren = new GetAllChildren();
        getAllChildren.execute(new Child());
        return getAllChildren.getChildren();
    }

    public void AddNewAttendance(List<Attendance> attendances) throws Exception {
        AddNewAttendance addNewAttendance = new AddNewAttendance();
        addNewAttendance.execute(attendances);

    }

    public List<UserProfile> getAllUsers() throws Exception {
        GetAllUsers getAllUsers = new GetAllUsers();
        getAllUsers.execute(new UserProfile());
        return getAllUsers.getUsers();
    }

    public void editUserStatus(List<UserProfile> userProfiles) throws Exception {
        EditUserStatus editUserStatus = new EditUserStatus();
        editUserStatus.execute(userProfiles);
    }

    public List<Attendance> getAttendances(Attendance at) throws Exception {
        GetAttendancesByOptionalProgram getAttendancesByOptionalProgram = new GetAttendancesByOptionalProgram();
        getAttendancesByOptionalProgram.execute(at);
        return getAttendancesByOptionalProgram.getAttendances();
    }

    public Object getAttendanceNullEndDate(Attendance at) throws Exception {
        GetAttendancesByOptionalProgramNullEndDate getAttendancesByOptionalProgramNullEndDate = new GetAttendancesByOptionalProgramNullEndDate();
        getAttendancesByOptionalProgramNullEndDate.execute(at);
        return getAttendancesByOptionalProgramNullEndDate.getAttendances();
    }

    public Object getAttendanceNotNullEndDate(Attendance at) throws Exception {
        GetAttendancesByOptionalProgramNotNullEndDate getAttendancesByOptionalProgramNotNullEndDate = new GetAttendancesByOptionalProgramNotNullEndDate();
        getAttendancesByOptionalProgramNotNullEndDate.execute(at);
        return getAttendancesByOptionalProgramNotNullEndDate.getAttendances();
    }

    public List<Employer> getAllEmployers() throws Exception {
        GetAllEmployers getAllEmployers = new GetAllEmployers();
        getAllEmployers.execute(new Employer());
        return getAllEmployers.getEmployers();
    }

    public void editChild(Child ec) throws Exception {
        EditChild editChild = new EditChild();
        editChild.execute(ec);
    }

    public void deleteChild(Child dc) throws Exception {
        DeleteChild deleteChild = new DeleteChild();
        deleteChild.execute(dc);
    }

    public void editParent(Parent ep) throws Exception {
        EditParent editParent = new EditParent();
        editParent.execute(ep);
    }

    public void deleteParent(Parent dp) throws Exception {
        DeleteParent deleteParent = new DeleteParent();
        deleteParent.execute(dp);
    }

    public void editEmployer(Employer ee) throws Exception {
        EditEmployer editEmployer = new EditEmployer();
        editEmployer.execute(ee);
    }

    public void deleteEmployer(Employer de) throws Exception {
        DeleteEmployer deleteEmployer = new DeleteEmployer();
        deleteEmployer.execute(de);
    }

    public void editOptionalProgram(OptionalProgram eop) throws Exception {
        EditOptionalProgram editOptionalProgram = new EditOptionalProgram();
        editOptionalProgram.execute(eop);
    }

    public void deleteOptionalxProgram(OptionalProgram dop) throws Exception {
        DeleteOptionalProgram deleteOptionalProgram = new DeleteOptionalProgram();
        deleteOptionalProgram.execute(dop);
    }

    public void editUserPassword(UserProfile up) throws Exception {
        EditUserPassword editUserPassword = new EditUserPassword();
        editUserPassword.execute(up);
    }

    public void quitAttendance(Attendance a) throws Exception {
        QuitAttendance quitAttendance = new QuitAttendance();
        quitAttendance.execute(a);
    }

    public Object getChild(Child searchedChild) throws Exception {
        GetChild getChild = new GetChild();
        getChild.execute(searchedChild);
        return getChild.getChild();
    }

    public Object getAllAttendances() throws Exception {
        GetAllAttendances getAllAttendances = new GetAllAttendances();
        getAllAttendances.execute(new Attendance());
        return getAllAttendances.getAttendances();
    }

    public Object getSearchedAttendance(Attendance sa) throws Exception {
        GetSearchedAttendances getSearchedAttendances = new GetSearchedAttendances();
        getSearchedAttendances.execute(sa);
        return getSearchedAttendances.getAttendances();
    }

    public void editAttendance(Attendance ea) throws Exception {
        EditAttendance editAttendance = new EditAttendance();
        editAttendance.execute(ea);
    }

    public void deleteAttendance(Attendance da) throws Exception {
        DeleteAttendance deleteAttendance = new DeleteAttendance();
        deleteAttendance.execute(da);
    }

    public List<Employer> getEmployers(Employer se) throws Exception {
        GetEmployers getEmployers = new GetEmployers();
        getEmployers.execute(se);
        return getEmployers.getEmployers();
    }

    public List<OptionalProgram> getOptionalPrograms(OptionalProgram sop) throws Exception {
        GetOptionalPrograms getOptionalPrograms = new GetOptionalPrograms();
        getOptionalPrograms.execute(sop);
        return getOptionalPrograms.getOptionalPrograms();
    }

    public Object getAttendance(Attendance sa) throws Exception {
        GetAttendance getAttendance = new GetAttendance();
        getAttendance.execute(sa);
        return getAttendance.getAttendance();
    }

    public void addNewParentChild(Child pc) throws Exception {
        AddNewParentChild addNewParentChild = new AddNewParentChild();
        addNewParentChild.execute(pc);
    }

    public void editAndDeleteAttendances(EditAndDeleteList editAndDeleteList) throws Exception {
        EditAndDeleteAttendances editAndDeleteAttendances = new EditAndDeleteAttendances();
        editAndDeleteAttendances.execute(editAndDeleteList);
    }

    public void editAndDeleteChildren(EditAndDeleteList editAndDeleteList) throws Exception {
        EditAndDeleteChildren editAndDeleteChildren = new EditAndDeleteChildren();
        editAndDeleteChildren.execute(editAndDeleteList);
    }

    public void editAndDeleteEmployers(EditAndDeleteList editAndDeleteList) throws Exception {
        EditAndDeleteEmployers editAndDeleteEmployers = new EditAndDeleteEmployers();
        editAndDeleteEmployers.execute(editAndDeleteList);
    }

    public void editAndDeleteOptionalPrograms(EditAndDeleteList editAndDeleteList) throws Exception {
        EditAndDeleteOptionalPrograms editAndDeleteOptionalPrograms = new EditAndDeleteOptionalPrograms();
        editAndDeleteOptionalPrograms.execute(editAndDeleteList);
    }

    public void editAndDeleteParents(EditAndDeleteList editAndDeleteList) throws Exception {
        EditAndDeleteParents editAndDeleteParents = new EditAndDeleteParents();
        editAndDeleteParents.execute(editAndDeleteList);
    }

  

   

}
