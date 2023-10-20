import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
  private final String accountHolderName;
  private final String accountNumber;
  private float accountBalance;
  private List<String> transactions;
  private boolean closed = false;
  private LocalDate accountCreationDate;
  private LocalDate accountClosingDate;

  // Constructors
  public BankAccount(String accountHolderName) {
    this.accountHolderName = accountHolderName;
    this.accountBalance = 0;
  }

  public BankAccount(String accountHolderName, float accountBalance) {
    this.accountHolderName = accountHolderName;
    this.accountBalance = accountBalance;
  }

  // Methods
  public void deposit(float depositAmount) {
    // If account is closed or incorrect amount.
    if (closed == true || depositAmount <= 0) {
      throw new IllegalArgumentException("Incorrect deposit amount, or account is closed.");
    }

    accountBalance += depositAmount;
    String transaction = "Deposit of $" + depositAmount + " at " + getCurrentDateTime();
    setTransactions(transaction);
  }

  public void withdraw(float withdrawAmount) {
    // If account is closed or incorrect amount.
    if (closed == true || withdrawAmount <= 0) {
      throw new IllegalArgumentException("Incorrect deposit amount, or account is closed.");
    }

    accountBalance -= withdrawAmount;
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
  public String getAccountHolderName() { // No setter for this
    return accountHolderName;
  }
  
  public String getAccountNumber() { // No setter for this
    return accountNumber;
  }
  
  public float getAccountBalance() {
    return accountBalance;
  }

  public void setAccountBalance(float accountBalance) {
    this.accountBalance = accountBalance;
  }

  public List<String> getTransactions() {
    return transactions;
  }

  public void setTransactions(String newTransaction) { // Adds a new transaction.
    if (this.transactions == null) {
      this.transactions = new ArrayList<>(); // For if transactions list is not initialised yet.
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
