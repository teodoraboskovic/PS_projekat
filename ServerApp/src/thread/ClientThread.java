/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import static communication.OperationType.ADD_NEW_ATTENDANCE;
import static communication.OperationType.ADD_NEW_CHILD;
import static communication.OperationType.ADD_NEW_OPTIONAL_PROGRAM;
import static communication.OperationType.ADD_NEW_PARENT;
import static communication.OperationType.ADD_NEW_WORKER;
import static communication.OperationType.DELETE_CHILD;
import static communication.OperationType.DELETE_EMPLOYER;
import static communication.OperationType.DELETE_PARENT;
import static communication.OperationType.EDIT_AND_DELETE_ATTENDANCES;
import static communication.OperationType.EDIT_AND_DELETE_CHILDREN;
import static communication.OperationType.EDIT_AND_DELETE_EMPLOYERS;
import static communication.OperationType.EDIT_AND_DELETE_OPTIONAL_PROGRAMS;
import static communication.OperationType.EDIT_CHILD;
import static communication.OperationType.EDIT_EMPLOYER;
import static communication.OperationType.EDIT_OPTIONAL_PROGRAM;
import static communication.OperationType.EDIT_PARENT;
import static communication.OperationType.EDIT_USER_PASSWORD;
import static communication.OperationType.EDIT_USER_STATUS;
import static communication.OperationType.GET_ALL_CHILDREN;
import static communication.OperationType.GET_ALL_OPTIONAL_PROGRAMS;
import static communication.OperationType.GET_ALL_PARENTS;
import static communication.OperationType.GET_ATTENDANCES;
import static communication.OperationType.GET_ATTENDANCES_NULL_END_DATE;
import static communication.OperationType.GET_PARENT;
import static communication.OperationType.GET_ALL_USERS;
import static communication.OperationType.GET_CHILD;
import static communication.OperationType.GET_EMPLOYERS;
import static communication.OperationType.LOGIN;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import controller.Controller;
import domain.Attendance;
import domain.Child;
import domain.EditAndDeleteList;
import domain.Employer;
import domain.OptionalProgram;
import domain.Parent;
import domain.UserProfile;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author PC
 */
public class ClientThread extends Thread {

    private Sender sender;
    private Receiver receiver;
    private Controller controller;
    private final Socket clientSocket;
    private ServerThread server;//referenca na server zbog pristupa listi klijenata
    private UserProfile loginUser;//za svaku nit cuvam ulogovanog usera
    private boolean loggedout = false;
    private boolean isSocketOpen = true;

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setIsSocketOpen(boolean isSocketOpen) {
        this.isSocketOpen = isSocketOpen;
    }

    public boolean isIsSocketOpen() {
        return isSocketOpen;
    }
    

    public ClientThread(Socket clientSocket, ServerThread server) {
        this.clientSocket = clientSocket;
        this.server = server;//referenca na server zbog pristupa listi klijenata
        sender = new Sender(clientSocket);
        receiver = new Receiver(clientSocket);
        controller = new Controller();
    }

    @Override
    public void run() {
        while (isSocketOpen) {
            try {
                Request request = (Request) receiver.receive();
                Response response = new Response();
                try {
                    switch (request.getOperationType()) {
                        case LOGIN:
                            UserProfile user = (UserProfile) request.getArgument();
                            //provera-da li je korisnik vec prijavljen?
                            if (!server.isClientLoggedIn(user)) {
                                response.setResult(controller.login(user));
                                //za uspesno logovanje, unesenog usera smestamo u loginUser prom
                                loginUser = user;
                            } else {
                                throw new Exception("User is already loged in");
                            }
                            break;
                        case ADD_NEW_PARENT:
                            Parent parent = (Parent) request.getArgument();
                            controller.addNewParent(parent);
                            response.setResult(parent);
                            break;
                        case ADD_NEW_CHILD:
                            Child child = (Child) request.getArgument();
                            controller.addNewChild(child);
                            response.setResult(child);
                            break;
                        case GET_ALL_PARENTS:
                            response.setResult(controller.getAllParents());
                            break;
                        case GET_ALL_OPTIONAL_PROGRAMS:
                            response.setResult(controller.getAllOptionalPrograms());
                            break;
                        case ADD_NEW_WORKER:
                            Employer employer = (Employer) request.getArgument();
                            controller.addNewEmployer(employer);
                            response.setResult(employer);
                            break;
                        case ADD_NEW_OPTIONAL_PROGRAM:
                            OptionalProgram optionalProgram = (OptionalProgram) request.getArgument();
                            controller.addNewOptionalProgram(optionalProgram);
                            response.setResult(optionalProgram);
                            break;
                        case GET_PARENT:
                            Parent childParent = (Parent) request.getArgument();
                            response.setResult(controller.getParent(childParent));
                            break;
                        case GET_ALL_CHILDREN:
                            response.setResult(controller.getAllChildren());
                            break;
                        case ADD_NEW_ATTENDANCE:
                            List<Attendance> attendances = (List<Attendance>) request.getArgument();
                            controller.AddNewAttendance(attendances);
                            response.setResult(attendances);
                            break;
                        case GET_ALL_USERS:
                            response.setResult(controller.getAllUsers());
                            break;
                        case EDIT_USER_STATUS:
                            List<UserProfile> userProfiles = (List<UserProfile>) request.getArgument();
                            controller.editUserStatus(userProfiles);
                            response.setResult(userProfiles);
                            break;
                        case GET_ATTENDANCES:
                            Attendance at = (Attendance) request.getArgument();
                            response.setResult(controller.getAttendances(at));
                            break;
                        case GET_ATTENDANCES_NULL_END_DATE:
                            at = (Attendance) request.getArgument();
                            response.setResult(controller.getAttendanceNullEndDate(at));
                            break;
                        case GET_ATTENDANCES_NOT_NULL_END_DATE:
                            at = (Attendance) request.getArgument();
                            response.setResult(controller.getAttendanceNotNullEndDate(at));
                            break;
                        case GET_ALL_EMPLOYERS:
                            response.setResult(controller.getAllEmployers());
                            break;
                        case EDIT_CHILD:
                            Child ec = (Child) request.getArgument();
                            controller.editChild(ec);
                            response.setResult(ec);
                            break;
                        case DELETE_CHILD:
                            Child dc = (Child) request.getArgument();
                            controller.deleteChild(dc);
                            response.setResult(dc);
                            break;
                        case EDIT_PARENT:
                            Parent ep = (Parent) request.getArgument();
                            controller.editParent(ep);
                            response.setResult(ep);
                            break;
                        case DELETE_PARENT:
                            Parent dp = (Parent) request.getArgument();
                            controller.deleteParent(dp);
                            response.setResult(dp);
                            break;
                        case EDIT_EMPLOYER:
                            Employer ee = (Employer) request.getArgument();
                            controller.editEmployer(ee);
                            response.setResult(ee);
                            break;
                        case DELETE_EMPLOYER:
                            Employer de = (Employer) request.getArgument();
                            controller.deleteEmployer(de);
                            response.setResult(de);
                            break;
                        case EDIT_OPTIONAL_PROGRAM:
                            OptionalProgram eop = (OptionalProgram) request.getArgument();
                            controller.editOptionalProgram(eop);
                            response.setResult(eop);
                            break;
                        case DELETE_OPTIONAL_PROGRAM:
                            OptionalProgram dop = (OptionalProgram) request.getArgument();
                            controller.deleteOptionalxProgram(dop);
                            response.setResult(dop);
                            break;
                        case EDIT_USER_PASSWORD:
                            UserProfile up = (UserProfile) request.getArgument();
                            controller.editUserPassword(up);
                            response.setResult(up);
                            break;
                        case QUIT_ATTENDANCE:
                            Attendance a = (Attendance) request.getArgument();
                            controller.quitAttendance(a);
                            response.setResult(a);
                            break;
                        case GET_CHILD:
                            Child sc = (Child) request.getArgument();
                            response.setResult(controller.getChild(sc));
                            break;
                        case GET_ALL_ATTENDANCES:
                            response.setResult(controller.getAllAttendances());
                            break;
                        case GET_SEARCHED_ATTENDANCES:
                            Attendance sAttendance = (Attendance) request.getArgument();
                            response.setResult(controller.getSearchedAttendance(sAttendance));
                            break;
                        case EDIT_ATTENDANCE:
                            Attendance ea = (Attendance) request.getArgument();
                            controller.editAttendance(ea);
                            response.setResult(ea);
                            break;
                        case DELETE_ATTENDANCE:
                            Attendance da = (Attendance) request.getArgument();
                            controller.deleteAttendance(da);
                            response.setResult(da);
                            break;
                        case GET_EMPLOYERS:
                            Employer se = (Employer) request.getArgument();
                            response.setResult(controller.getEmployers(se));
                            break;
                        case GET_OPTIONAL_PROGRAMS:
                            OptionalProgram sop = (OptionalProgram) request.getArgument();
                            response.setResult(controller.getOptionalPrograms(sop));
                            break;
                        case GET_ATTENDANCE:
                            Attendance sa = (Attendance) request.getArgument();
                            response.setResult(controller.getAttendance(sa));
                            break;
                        case ADD_NEW_PARENT_CHILD:
                            Child pc = (Child) request.getArgument();
                            controller.addNewParentChild(pc);
                            response.setResult(pc);
                            break;
                        case EDIT_AND_DELETE_ATTENDANCES:
                            EditAndDeleteList editAndDeleteList = (EditAndDeleteList) request.getArgument();
                            controller.editAndDeleteAttendances(editAndDeleteList);
                            response.setResult(editAndDeleteList);
                            break;
                        case EDIT_AND_DELETE_CHILDREN:
                            EditAndDeleteList editAndDeleteList2 = (EditAndDeleteList) request.getArgument();
                            controller.editAndDeleteChildren(editAndDeleteList2);
                            response.setResult(editAndDeleteList2);
                            break;
                        case EDIT_AND_DELETE_EMPLOYERS:
                            EditAndDeleteList editAndDeleteList3 = (EditAndDeleteList) request.getArgument();
                            controller.editAndDeleteEmployers(editAndDeleteList3);
                            response.setResult(editAndDeleteList3);
                            break;
                        case EDIT_AND_DELETE_OPTIONAL_PROGRAMS:
                            EditAndDeleteList editAndDeleteList4 = (EditAndDeleteList) request.getArgument();
                            controller.editAndDeleteOptionalPrograms(editAndDeleteList4);
                            response.setResult(editAndDeleteList4);
                            break;
                        case EDIT_AND_DELETE_PARENTS:
                            EditAndDeleteList editAndDeleteList5 = (EditAndDeleteList) request.getArgument();
                            controller.editAndDeleteParents(editAndDeleteList5);
                            response.setResult(editAndDeleteList5);
                            break;
                        case LOGOUT:
                            UserProfile userp = (UserProfile) request.getArgument();
                            response.setResult(userp);
                            server.logout(userp);
                            loggedout = true;
                            break;
                        
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    response.setException(ex);
                }
                sender.send(response);
                if (loggedout) {
                    clientSocket.close();
                    isSocketOpen = false;
                    System.out.println("Klijent " + loginUser + " je diskonektovan");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    //ako je user uspesno ulogovan cuvamo ga u prom loginUser
    //pravimo geter zbog kasnije provere, ukoliko isti korisnik opet proba da se uloguje
    public UserProfile getLoginUser() {
        return loginUser;
    }

}
