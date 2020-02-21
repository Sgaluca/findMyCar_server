/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findmycar_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sgarlato.luca
 */
public class Server {

    ServerSocket serverSocket;
    Socket client;
    int ServerPort;
    BufferedReader inputFromClient;
    PrintStream outputToClient;

    public Server(int ServerPort) {
        this.ServerPort = ServerPort;
    }

    public Socket waitConnection() {
        try {
            serverSocket = new ServerSocket(ServerPort);
            System.out.println("Server avviato...");
            System.out.println("pronto per la connessione");
            
        } catch (IOException ex) {
            System.out.println("Errore crazione server");
            System.out.println(ex.getMessage());
        }
        try {
            client = serverSocket.accept();
            System.out.println("Client connesso: " + client.toString());
        } catch (Exception e) {
            System.out.println("Errore connessione");
            System.out.println(e.getMessage());

        }
        try {
            inputFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outputToClient = new PrintStream(client.getOutputStream());
            
        } catch (IOException ex) {
            
            System.out.println("Errore connessione");
            System.out.println(ex.getMessage());

        }

        return client;

    }

    public void close() {
        try {
            serverSocket.close();
        } catch (IOException ex) {
            System.out.println("Errore chiusura connessione");
            System.out.println(ex.getMessage());
        }
    }
}
