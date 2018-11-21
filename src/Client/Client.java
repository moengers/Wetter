package Client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Generelle Client Clase
 * Nur Basis, soll nicht alleine benutzt werden.
 */
public class Client {

    private final int PORT;
    private Socket socket;
    private boolean loop;

    /**
     * constructor
     *setzt Oort
     * loop: einmalige(loop=false) oder unendliche Abfrage(loop=true)
     * @param PORT Server Port
     */
    Client(int PORT) {
        this.PORT = PORT;
        try {
            this.socket = new Socket(InetAddress.getLocalHost(), PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        loop = true;
    }

    /**
     * Auzuführende Methode um den Client zu starten
     */
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

    /**
     * Die Funktion soll einen String generieren, welcher vom Client an den Server gesendet wird.
     * @return zu sendener String
     */
    protected String sendSomething(){
        System.out.println("Do something");
        return "something";
    }

    /**
     * Beendet den Client
     */
    protected void closeClient(){
        loop = false;
    }


}
