package Main;

import Client.*;
import Server.*;


import java.io.IOException;


public class Main {

    /**
     * Probe Echo-Server
     * @param args Standard Main
     */
    public static void main(String[] args) {
        EchoServer server = null;
        try {
            server = new EchoServer(6789);
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.start();

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        InputSendClient client = new InputSendClient(6789);
        client.clientStart();

        //server.stop();
    }
}
