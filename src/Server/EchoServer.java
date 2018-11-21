package Server;

import java.io.IOException;

public class EchoServer extends Server {


    public EchoServer(int port) throws IOException {
        super(port);
    }

    @Override
    protected void doSomething(String data, String clientAddress){
        System.out.println("\r\nMessage from " + clientAddress + ": " + data + "\n");
    }
}
