
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to DBS!");

        BankAccount bankAccountOne = new BankAccount();
        BankAccount bankAccountTwo = new BankAccount("Khairul");
        BankAccount bankAccountThree = new BankAccount("Bob",  (float) 1000);
        
        String accountNumberOne = bankAccountOne.getAccountNumber();
        System.out.println("Account number: " + accountNumberOne);


        String accountNumberTwo = bankAccountTwo.getAccountNumber();
        String accountNameTwo = bankAccountTwo.getName();
        System.out.println("Account number: " + accountNumberTwo);
        System.out.println("Account name: " + accountNameTwo);

        String accountNumberThree = bankAccountThree.getAccountNumber();
        String accountNameThree = bankAccountThree.getName();
        Float bankAccountBalanceThree = bankAccountThree.getBalance();
        System.out.println("Account number: " + accountNumberThree);
        System.out.println("Account name: " + accountNameThree);
        System.out.println("Account balance: " + bankAccountBalanceThree);

        


    }
}
