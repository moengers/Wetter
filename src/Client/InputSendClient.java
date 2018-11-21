package Client;

import java.util.Scanner;

/**
 * Abgeleitete Klasse vom Client
 * soll den Keyboard Input an den Server senden.
 */
public class InputSendClient extends Client{

    private Scanner scanner;

    /**
     * constructor
     * @param PORT Server Port
     */
    public InputSendClient(int PORT) {
        super(PORT);
        this.scanner = new Scanner(System.in);
    }

    /**
     *
     * @return Input vom Keyboard
     */
    @Override
    protected String sendSomething() {
        return scanner.nextLine();
    }
}
