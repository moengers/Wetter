package Client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


public class Client {

    private final int PORT;
    private Socket socket;
    private boolean loop;

    Client(int PORT) {
        this.PORT = PORT;
        try {
            this.socket = new Socket(InetAddress.getLocalHost(), PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        loop = true;
    }

    public void clientStart(){
        while (loop) {
            PrintWriter out = null;
            try {
                out = new PrintWriter(this.socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String data = sendSomething();
            if(data != null){
                out.println(data);
                out.flush();
            }
        }
    }

    protected String sendSomething(){
        System.out.println("Do something");
        return "something";
    }

    protected void closeClient(){
        loop = false;
    }


}
