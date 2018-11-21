package Server;

import java.io.IOException;

public class EchoServer extends Server {

    /**
     * constructor
     * @param port offener Port für die Clients
     * @throws IOException vom Server.Sever
     */
    public EchoServer(int port) throws IOException {
        super(port);
    }

    /**
     * Implementierung des Echos
     * @param data Die vom Client geschickten Daten
     * @param clientAddress Adresse des Clients
     */
    @Override
    protected void doSomething(String data, String clientAddress){
        System.out.println("\r\nMessage from " + clientAddress + ": " + data + "\n");
    }
}
