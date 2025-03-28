/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import domain.UserProfile;
import view.form.MainServerForm;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.text.DateFormatter;
import view.components.LoggedInUsersTableModel;

/**
 *
 * @author PC
 */
public class LoggedInUsersThread extends Thread {

    ServerThread server;
    MainServerForm form;

    public LoggedInUsersThread(ServerThread server, MainServerForm form) {
        this.server = server;
        this.form = form;
    }

    @Override
    public void run() {
        setLoggedInUsers();
    }

    public void setLoggedInUsers() {
        while (true) {
            if (server != null) {
                List<ClientThread> clients = server.getClients();
                List<UserProfile> users = new ArrayList<>();
                for (ClientThread client : clients) {
                    if (client.getLoginUser() != null) {
                        users.add(client.getLoginUser());
                    }
                }
                form.reloadLoggedAdmins(users);
//                System.out.println(users);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(LoggedInUsersThread.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

}
