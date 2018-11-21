package Client;

import java.util.Scanner;

public class InputSendClient extends Client{
    private Scanner scanner;

    public InputSendClient(int PORT) {
        super(PORT);
        this.scanner = new Scanner(System.in);
    }

    @Override
    protected String sendSomething() {
        return scanner.nextLine();
    }
}
