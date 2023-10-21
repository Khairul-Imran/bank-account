# BankAccount Project

The aim of this project is to provide a simple Java implementation of a `BankAccount` and a `FixedDepositAccount` class. The `BankAccount` class represents a basic bank account with functionalities like deposit, withdraw, and balance inquiry, while the `FixedDepositAccount` class extends the `BankAccount` class to represent fixed deposit accounts with additional features.

## Classes

### `BankAccount`

The `BankAccount` class is a basic bank account class with the following features:

- **Members**:
  - `name`: Represents the account holder's name.
  - `accountNumber`: A unique account number.
  - `balance`: The account's balance.
  - `transactions`: A list of transaction records.
  - `closed`: Tells us whether the account has been closed or not.
  - `accountCreationDate`: When the account was created.
  - `accountClosingDate`: When the account is closed.

- **Methods**:
  - `deposit(Float depositAmount)`: Deposits the specified amount into the account.
  - `withdraw(Float withdrawAmount)`: Withdraws the specified amount from the account.
  - `getBalance()`: Returns the current balance.
  - `closeAccount()`: Closes the account.
  - Includes the necessary getters and setters.

### `FixedDepositAccount`

The `FixedDepositAccount` class extends the `BankAccount` class to represent fixed deposit accounts with the following additional features:

- **Members**:
  - `interest`: The interest rate for the fixed deposit account.
  - `duration`: The duration of the fixed deposit account.
  - `wasInterestChanged`: Tells us whether the interest was changed.
  - `wasDurationChanged`: Tells us whether the duration was changed.

- **Methods**:
  - Includes the necessary getters and setters.
  - Overrides for the following methods:
  - `getBalance()`: Returns the balance of the fixed deposit account, including interest.
  - `deposit(Float depositAmount)`: Does nothing.
  - `withdraw(Float withdrawAmount)`: Does nothing.

## Usage

To use these classes in your project, you can create instances of `BankAccount` or `FixedDepositAccount` and call their methods to perform banking operations.

Example usage:

```java
// Create a BankAccount
BankAccount account = new BankAccount(1000.0);

// Perform operations
account.deposit(500.0);
account.withdraw(200.0);
double balance = account.getBalance();

// Create a FixedDepositAccount
FixedDepositAccount fixedDeposit = new FixedDepositAccount(name, 10000.0, 0.05, 12);

// Set interest and duration
fixedDeposit.setInterest(0.06);
fixedDeposit.setDuration(24);

// Get the balance with interest
double balanceWithInterest = fixedDeposit.getBalance();
