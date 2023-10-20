public class FixedDepositAccount extends BankAccount{
  private Float interest = Float.valueOf((float)3);
  private Integer duration = 6;
  private boolean wasInterestChanged = false;
  private boolean wasDurationChanged = false;

  public FixedDepositAccount(String name, Float balance) {
    super(name, balance);
  }

  public FixedDepositAccount(String name, Float balance, Float interest) {
    super(name, balance);
    this.interest = interest;
  }

  public FixedDepositAccount(String name, Float balance, Float interest, Integer duration) {
    super(name, balance);
    this.interest = interest;
    this.duration = duration;
  }

  // Methods to override
  @Override
  public void deposit(Float depositAmount) {
    // Do nothing
  }

  @Override
  public void withdraw(Float withdrawAmount) {
    // Do nothing
  }

  @Override
  public Float getBalance() {
    return super.getBalance() + (super.getBalance() * interest);
  }


  // Getters and setters
  public Float getInterest() {
    return interest;
  }

  public void setInterest(Float interest) {
    if (wasInterestChanged) {
      throw new IllegalArgumentException("Interest has been changed once before.");
    }

    this.interest = interest;
    wasInterestChanged = true;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    if (wasDurationChanged) {
      throw new IllegalArgumentException("Duration has been changed once before.");
    }

    this.duration = duration;
    wasDurationChanged = true;
  }
  
}
