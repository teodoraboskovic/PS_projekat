/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import static communication.OperationType.LOGIN;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import controller.Controller;
import domain.Attendance;
import domain.Child;
import domain.Employer;
import domain.OptionalProgram;
import domain.Parent;
import domain.UserProfile;
import view.form.MainServerForm;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import thread.ClientThread;

/**
 *
 * @author PC
 */
public class ServerThread extends Thread {

    private Controller controller;
    private Sender sender;
    private Receiver receiver;
    private List<ClientThread> clients;
    private ServerSocket serverSocket;

    public ServerThread() throws IOException {
        controller = new Controller();
        clients = new ArrayList<>();
        serverSocket = new ServerSocket(9000);
    }

    @Override
    public void run() {
        startServer();
    }

    public void startServer() {
        while (!serverSocket.isClosed()) {
            try {
                System.out.println("Ceka se konekcija...");
                Socket socket = serverSocket.accept();
                System.out.println("Konekcija uspesna");
                ClientThread ct = new ClientThread(socket, this);
                //prosledjujem server(this) zbog pristupa listi svih clientThread-ova u klijentskoj niti jednog klijenta
                ct.start();
                clients.add(ct);//svi klijenti povezani za server
                //singlnton klasa ClientSession koja ima listu povezanih klijenata
                //umesto clients.add(ct)

            } catch (IOException ex) {
                if (serverSocket.isClosed()) {
                    break;
                }
                ex.printStackTrace();
            }
        }
        stopAllThreads();

    }

    //prolazimo kroz listu klijentskih niti
    //poredimo prosledjene kredencijale sa svakim pojedinacnim userom iz liste klijentskih niti
    //ukoliko je korisnik vec ulogovan vracamo true, u suprotnom false
    public boolean isClientLoggedIn(UserProfile user) {
        for (ClientThread client : clients) {
            if (client.getLoginUser() != null) {//ne proveravamo one klijentske niti za koje se kljenti jos nisu ulogovali
                if (user.equals(client.getLoginUser())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void logout(UserProfile userp) {
        for (int i = 0; i < clients.size(); i++) {
            if (userp.equals(clients.get(i).getLoginUser())) {
                clients.remove(i);
            }
        }
    }

    public List<ClientThread> getClients() {
        return clients;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    private void stopAllThreads() {
        Iterator<ClientThread> iterator = clients.iterator();
        while (iterator.hasNext()) {
            ClientThread client = iterator.next();
            client.setIsSocketOpen(false);
            try {
                client.getClientSocket().close();
                iterator.remove();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
