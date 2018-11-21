package Server;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{

    private final int PORT;
    private ServerSocket server;

    /**
     * constructor
     * @param port offener Port für die Clients
     * @throws IOException InetAddress.getLocalHost()
     */
    Server (int port) throws IOException {
        PORT = port;
        this.server = new ServerSocket(PORT, 1, InetAddress.getLocalHost());

    }

    /**
     * startet den Thread
     */
    public void run(){
        serverSetup();
    }

    /**
     * startet den TCP Server
     */
    private void serverSetup() {
        String data;
        Socket client = null;
        try {
            client = this.server.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(client != null){
            String clientAddress = client.getInetAddress().getHostAddress();
            System.out.println("\r\nNew connection from " + clientAddress);

            BufferedReader in;
            try {
                in = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));
                while ( (data = in.readLine()) != null ) {
                    doSomething(data, clientAddress);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * in Unterklassen zu implementierende Methoden, die den Input verabreitet
     * @param data Die vom Client geschickten Daten
     * @param clientAddress Adresse des Clients
     */
    protected void doSomething(String data, String clientAddress){
        System.out.println("DoSomething");
    }

}
