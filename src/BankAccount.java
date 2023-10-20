import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
  private final String name;
  private final String accountNumber;
  private Float balance;
  private List<String> transactions;
  private boolean closed = false;
  private LocalDate accountCreationDate;
  private LocalDate accountClosingDate;

  // Constructors
  public BankAccount() {} // No-argument constructor. 

  public BankAccount(String name) {
    this.name = name;
    this.balance = Float.valueOf((float)0);
  }

  public BankAccount(String name, Float balance) {
    this.name = name;
    this.balance = balance;
  }

  // Methods
  public void deposit(Float depositAmount) {
    if (closed == true || depositAmount <= 0) { // If account is closed or incorrect amount.
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
    closed = true;
  }
  
  public LocalDate getAccountCreationDate() {
    return accountCreationDate;
  }

  public void setAccountCreationDate(LocalDate accountCreationDate) {
    this.accountCreationDate = accountCreationDate;
  }

  public LocalDate getAccountClosingDate() {
    return accountClosingDate;
  }

  public void setAccountClosingDate(LocalDate accountClosingDate) {
    this.accountClosingDate = accountClosingDate;
  }

}
