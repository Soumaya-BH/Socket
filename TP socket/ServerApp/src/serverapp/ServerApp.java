package serverapp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

    static final int port = 1500;

    public static void main(String[] args) throws Exception {

        // Listen to a specific port

        ServerSocket s = new ServerSocket(port);
        System.out.println("Waiting for connection");
        Socket socClient = s.accept(); // Accept a client socket
        System.out.println("Connection established");

        // Initialize in / out

        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);

        // Read message sent by the client
        String str = inServer.readLine();
        System.out.println("enitier liee");
        int nb =Integer.parseInt(str);
        for(int i=1;i<=nb;i++){
            int cpt=0;
            for(int j=2;j<i;j++){
                if(i%j==0){
                    cpt++;
                }
            }
            if(cpt ==0){
                System.out.println(i+" est un nb premier");
            }
        }

        // Close in / out
        inServer.close();
        outServer.close();

        // Close client socket
        socClient.close();
    }
}