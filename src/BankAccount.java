import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankAccount {
  private String name; // Set once, cannot change.
  private String accountNumber; // Set once, cannot change.
  private Float balance;
  private List<String> transactions;
  private boolean closed = false;
  private LocalDate accountCreationDate;
  private LocalDate accountClosingDate;

  // Constructors
  public BankAccount(String name, Float balance) {
    this.name = name;
    this.balance = balance;

    setAccountCreationDate();

    Random random = new Random();
    int randomAccountNumber = random.nextInt(1000000);
    accountNumber = String.format("%06d", randomAccountNumber);
  }

  public BankAccount(String name) {
    this(name, (float) 0);

    setAccountCreationDate();

    Random random = new Random();
    int randomAccountNumber = random.nextInt(1000000);
    accountNumber = String.format("%06d", randomAccountNumber);
  }

  public BankAccount() { // No-argument constructor. 
    setAccountCreationDate();
    setBalance((float)0);

    Random random = new Random();
    int randomAccountNumber = random.nextInt(1000000);
    accountNumber = String.format("%06d", randomAccountNumber);
  }

  // Methods
  public void deposit(Float depositAmount) {
    if (closed == true || depositAmount <= 0) {
      throw new IllegalArgumentException("Incorrect deposit amount, or account is closed.");
    }

    balance += depositAmount;
    String transaction = "Deposit of $" + depositAmount + " at " + getCurrentDateTime();
    setTransactions(transaction);
  }

  public void withdraw(Float withdrawAmount) {
    if (closed == true || withdrawAmount <= 0) {
      throw new IllegalArgumentException("Incorrect deposit amount, or account is closed.");
    }

    balance -= withdrawAmount;
    String transaction = "Withdrawal of $" + withdrawAmount + " at " + getCurrentDateTime();
    setTransactions(transaction);
  }

  // To return a formatted date and time.
  private String getCurrentDateTime() {
    LocalDateTime transactionTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy, HH:mm:ss");
    return transactionTime.format(formatter);
  }

  // All getters and setters
  public String getName() { // No setter for this
    return name;
  }
  
  public String getAccountNumber() { // No setter for this
    return accountNumber;
  }
  
  public Float getBalance() {
    return balance;
  }

  public void setBalance(Float balance) {
    this.balance = balance;
  }

  public List<String> getTransactions() {
    return transactions;
  }

  public void setTransactions(String newTransaction) { // Adds a new transaction.
    if (this.transactions == null) {
      this.transactions = new ArrayList<>(); // For if the transactions list is not initialised yet.
    }
    this.transactions.add(newTransaction);
  }

  public boolean isClosed() { // This method is like asking if the account is closed. Then you return true or false.
    return closed;
  }

  public void closeAccount() { // To actually close the account.
    setAccountClosingDate();
    closed = true;
  }
  
  public LocalDate getAccountCreationDate() {
    return accountCreationDate;
  }

  public void setAccountCreationDate() { // Not really necessary, since constructor sets it already.
    accountCreationDate = LocalDate.now();
  }

  public LocalDate getAccountClosingDate() {
    return accountClosingDate;
  }

  public void setAccountClosingDate() {
    accountClosingDate = LocalDate.now();
  }

  @Override
  public String toString() {
    if (closed == false) {
      return name + "'s Bank Account:" +
            "Date Created: " + accountCreationDate +
            "Account Number: " + accountNumber +
            "Balance: " + balance;
    } else {
      return name + "'s Bank Account:" +
            "Date Closed: " + accountClosingDate +
            "Account Number: " + accountNumber +
            "Balance: " + balance;
    }
    
  }

}
