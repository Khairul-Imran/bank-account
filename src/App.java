import java.io.Console;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to DBS!");
        System.out.println("Available commands: open, close, status, withdraw, deposit, list, exit.");

        Console cons = System.console();
        boolean continueLoop = false;
        
        BankAccount mainBankAccount = new BankAccount("Bob", (float) 0);

        while (!continueLoop) {
            String input = cons.readLine("> ").trim();
            Scanner scanner = new Scanner(input.toLowerCase()).useDelimiter("\\s*,\\s*");

            //System.out.println(scanner.next());
            //System.out.println(scanner.next());
            //continueLoop = true;
             
            switch (scanner.next()) {
                case "open": // Need to create a directory to store these.
                    String name = scanner.next();
                    Float openingBalance = Float.parseFloat(scanner.next());
                    BankAccount newBankAccount = new BankAccount(name, openingBalance);
                    System.out.println(newBankAccount);
                    break;
                
                case "close":
                    mainBankAccount.closeAccount();
                    System.out.println(mainBankAccount);
                    break;

                case "status":
                    System.out.println(mainBankAccount);
                    break;

                case "withdraw":
                    String withdrawAmount = scanner.next();
                    Float floatWithdrawAmount = Float.parseFloat(withdrawAmount);
                    mainBankAccount.withdraw(floatWithdrawAmount);
                    break;

                case "deposit":
                    String depositAmount = scanner.next();
                    Float floatDepositAmount = Float.parseFloat(depositAmount);
                    mainBankAccount.deposit(floatDepositAmount);
                    break;

                case "list":
                    List<String> transactions = mainBankAccount.getTransactions();
                    for (String transaction : transactions) {
                        System.out.println(transaction);
                    }
                    break;

                case "exit": 
                    System.out.printf("Have a nice day!\n");
                    continueLoop = true;
                    scanner.close();
                    break;

                default:
                    System.out.printf("Invalid command. Available commands: open, close, withdraw, deposit, list, exit. \n");
                    break;
            }
        }
    }
}
