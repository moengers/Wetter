package Server;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{

    private final int PORT;
    private ServerSocket server;

    Server (int port) throws IOException {
        PORT = port;
        this.server = new ServerSocket(PORT, 1, InetAddress.getLocalHost());

    }

    public void run(){
        serverSetup();
    }

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

    protected void doSomething(String data, String clientAddress){
        System.out.println("DoSomething");
    }

}
