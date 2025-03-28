/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uicontroller;

import communication.OperationType;
import communication.Receiver;
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
import view.form.LoginForm;
import view.form.MainForm;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author PC
 */
public class Controller {

    private Socket socket;
    private Sender sender;
    private Receiver receiver;
    private static Controller instance;
    


    private Controller() throws IOException {
        socket = new Socket("localhost", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    public static Controller getInstance() throws IOException {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }
            


    public Socket getSocket() {
        return socket;  // Expose the socket for ServerThread to use
    }

    public UserProfile login(UserProfile user) throws Exception {
        Request request = new Request();
        request.setArgument(user);
        request.setOperationType(OperationType.LOGIN);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (UserProfile) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void addNewParent(Parent parent) throws Exception {
        Request request = new Request(parent, OperationType.ADD_NEW_PARENT);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            parent.setId(((Parent) response.getResult()).getId());
        } else {
            throw response.getException();
        }
    }

    public List<Parent> getAllParents() throws Exception {
        Request request = new Request(null, OperationType.GET_ALL_PARENTS);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Parent>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void addNewChild(Child child) throws Exception {
        Request request = new Request(child, OperationType.ADD_NEW_CHILD);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            child.setId(((Child) response.getResult()).getId());
        } else {
            throw response.getException();
        }
    }

    public List<OptionalProgram> getAllOptionalPrograms() throws Exception {
        Request request = new Request(null, OperationType.GET_ALL_OPTIONAL_PROGRAMS);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<OptionalProgram>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void addNewEmployer(Employer employer) throws Exception {
        Request request = new Request(employer, OperationType.ADD_NEW_WORKER);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            employer.setId(((Employer) response.getResult()).getId());
        } else {
            throw response.getException();
        }
    }

    public void addNewOptionalProgram(OptionalProgram optionalProgram) throws Exception {
        Request request = new Request(optionalProgram, OperationType.ADD_NEW_OPTIONAL_PROGRAM);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            optionalProgram.setId(((OptionalProgram) response.getResult()).getId());
        } else {
            throw response.getException();
        }
    }

    public Parent getParent(Parent parent) throws Exception {
        Request request = new Request(parent, OperationType.GET_PARENT);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Parent) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Child> getAllChildren() throws Exception {
        Request request = new Request(null, OperationType.GET_ALL_CHILDREN);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Child>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void addNewAttendance(List<Attendance> attendances) throws Exception {
        Request request = new Request(attendances, OperationType.ADD_NEW_ATTENDANCE);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public List<UserProfile> getAllUsers() throws Exception {
        Request request = new Request(null, OperationType.GET_ALL_USERS);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<UserProfile>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void editUserStatus(List<UserProfile> users) throws Exception {
        Request request = new Request(users, OperationType.EDIT_USER_STATUS);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public List<Attendance> getAttendancesByOptionalProgram(Attendance attendance) throws Exception {
        Request request = new Request(attendance, OperationType.GET_ATTENDANCES);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Attendance>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Attendance> getAttendanceNullEndDate(Attendance a) throws Exception {
        Request request = new Request(a, OperationType.GET_ATTENDANCES_NULL_END_DATE);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Attendance>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Attendance> getAttendanceNotNullEndDate(Attendance a) throws Exception {
        Request request = new Request(a, OperationType.GET_ATTENDANCES_NOT_NULL_END_DATE);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Attendance>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Employer> getAllEmployers() throws Exception {
        Request request = new Request(null, OperationType.GET_ALL_EMPLOYERS);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Employer>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void editChild(Child ec) throws Exception {
        Request request = new Request(ec, OperationType.EDIT_CHILD);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public void deleteChild(Child dc) throws Exception {
        Request request = new Request(dc, OperationType.DELETE_CHILD);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public void editParent(Parent ep) throws Exception {
        Request request = new Request(ep, OperationType.EDIT_PARENT);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public void deleteParent(Parent dp) throws Exception {
        Request request = new Request(dp, OperationType.DELETE_PARENT);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public void editEmployer(Employer ee) throws Exception {
        Request request = new Request(ee, OperationType.EDIT_EMPLOYER);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public void deleteEmployer(Employer de) throws Exception {
        Request request = new Request(de, OperationType.DELETE_EMPLOYER);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public void editOptionalProgram(OptionalProgram eop) throws Exception {
        Request request = new Request(eop, OperationType.EDIT_OPTIONAL_PROGRAM);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public void deleteOptionalProgram(OptionalProgram dop) throws Exception {
        Request request = new Request(dop, OperationType.DELETE_OPTIONAL_PROGRAM);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public void editUserPassword(UserProfile user) throws Exception {
        Request request = new Request(user, OperationType.EDIT_USER_PASSWORD);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public void quitAttendance(Attendance attendance) throws Exception {
        Request request = new Request(attendance, OperationType.QUIT_ATTENDANCE);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public Child getChild(Child child) throws Exception {
        Request request = new Request(child, OperationType.GET_CHILD);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Child) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Attendance> getAllAttendances() throws Exception {
        Request request = new Request(null, OperationType.GET_ALL_ATTENDANCES);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Attendance>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Attendance> getSearchedAttendances(Attendance attendance) throws Exception {
        Request request = new Request(attendance, OperationType.GET_SEARCHED_ATTENDANCES);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Attendance>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void editAttendance(Attendance ea) throws Exception {
        Request request = new Request(ea, OperationType.EDIT_ATTENDANCE);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public void deleteAttendance(Attendance da) throws Exception {
        Request request = new Request(da, OperationType.DELETE_ATTENDANCE);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public List<Employer> getEmployers(Employer employer) throws Exception {
        Request request = new Request(employer, OperationType.GET_EMPLOYERS);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Employer>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<OptionalProgram> getOptionalPrograms(OptionalProgram optionalProgram) throws Exception {
        Request request = new Request(optionalProgram, OperationType.GET_OPTIONAL_PROGRAMS);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<OptionalProgram>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public Attendance getAttendance(Attendance attendance) throws Exception {
        Request request = new Request(attendance, OperationType.GET_ATTENDANCE);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Attendance) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void AddNewParentChild(Child child) throws Exception {
        Request request = new Request(child, OperationType.ADD_NEW_PARENT_CHILD);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            child.setId(((Child) response.getResult()).getId());
        } else {
            throw response.getException();
        }
    }

    public void editAndDeleteAttendances(EditAndDeleteList editAndDeleteList) throws Exception {
        Request request = new Request(editAndDeleteList, OperationType.EDIT_AND_DELETE_ATTENDANCES);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public void editAndDeleteChildren(EditAndDeleteList editAndDeleteList) throws Exception {
        Request request = new Request(editAndDeleteList, OperationType.EDIT_AND_DELETE_CHILDREN);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public void editAndDeleteEmployers(EditAndDeleteList editAndDeleteList) throws Exception {
        Request request = new Request(editAndDeleteList, OperationType.EDIT_AND_DELETE_EMPLOYERS);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public void editAndDeleteOptionalPrograms(EditAndDeleteList editAndDeleteList) throws Exception {
        Request request = new Request(editAndDeleteList, OperationType.EDIT_AND_DELETE_OPTIONAL_PROGRAMS);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public void editAndDeleteParents(EditAndDeleteList editAndDeleteList) throws Exception {
        Request request = new Request(editAndDeleteList, OperationType.EDIT_AND_DELETE_PARENTS);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public UserProfile logout(UserProfile user) throws Exception {
        Request request = new Request();
        request.setArgument(user);
        request.setOperationType(OperationType.LOGOUT);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (UserProfile) response.getResult();
        } else {
            throw response.getException();
        }
    }

}
