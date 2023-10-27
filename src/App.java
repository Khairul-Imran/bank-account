import java.io.Console;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to DBS!");

        // Insert the various commands that the user can give. (only at the beginning)

        Console cons = System.console();

        boolean continueLoop = false;
        String command = "";
        String amount = "";

        while (!continueLoop) {
            String input = cons.readLine("> ");
            Scanner scanner = new Scanner(input.toLowerCase());

            switch (scanner.next()) {
                case "open":
                    // To show date the acount was opened, account number, account holder name
                    break;
                
                case "close":
                    // To show date the account was closed, account number, account holder name.
                    break;

                case "withdraw":
                    // To show update balance, amount withdrew and at what time.
                    break;

                case "deposit":
                    // To show update balance, amount deposited and at what time.
                    break;

                case "list transactions":
                    // Lists transactions.
                    break;

                case "exit": 
                    // Exits program.
                    break;

                default:
                    break;
            }

        }


    }
}
