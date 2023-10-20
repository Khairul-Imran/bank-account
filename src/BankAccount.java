import java.time.LocalDate;
import java.util.List;

public class BankAccount {
  private final String accountHolderName;
  private final String accountNumber;
  private float accountBalance;
  private List<String> transactions;
  private boolean closed;
  private LocalDate accountCreationDate;
  private LocalDate accountClosingDate;

  public BankAccount(String accountHolderName) {
    this.accountHolderName = accountHolderName;
    this.accountBalance = 0;
  }

  public BankAccount(String accountHolderName, float accountBalance) {
    this.accountHolderName = accountHolderName;
    this.accountBalance = accountBalance;
  }

  // For accountHolderName
  public String getAccountHolderName() { // No setter for this
    return accountHolderName;
  }
  
  // For accountNumber
  public String getAccountNumber() { // No setter for this
    return accountNumber;
  }
  
  // For accountBalance
  public float getAccountBalance() {
    return accountBalance;
  }

  public void setAccountBalance(float accountBalance) {
    this.accountBalance = accountBalance;
  }

  // For transactions
  public List<String> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<String> transactions) {
    this.transactions = transactions;
  }

  // For closed
  public boolean isClosed() { // Not so sure about this
    return closed;
  }
  
  // For accountCreationDate
  public LocalDate getAccountCreationDate() {
    return accountCreationDate;
  }

  public void setAccountCreationDate(LocalDate accountCreationDate) {
    this.accountCreationDate = accountCreationDate;
  }

  // For accountClosingDate
  public LocalDate getAccountClosingDate() {
    return accountClosingDate;
  }

  public void setAccountClosingDate(LocalDate accountClosingDate) {
    this.accountClosingDate = accountClosingDate;
  }

}
