package bank;

import bank.exceptions.AmountException;

public class Account {
  private int id;
  private String type;
  private Double balance;

  public Account(int id, String type, Double balance) {
    setId(id);
    setType(type);
    setBalance(balance);
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Double getBalance() {
    return this.balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public void deposit(double amount) throws AmountException {
    if (amount < 1) {
      throw new AmountException("The mininum deposit is $1.00");
    } else {
      double newBalance = balance + amount;
      setBalance(newBalance);
      DataSource.updateAccountBalance(id, newBalance);
    }
  }

  public void withdrawl(double amount) throws AmountException {
    if (amount < 1) {
      throw new AmountException("The withdrawl amount must be greater than $0.00");
    } else if (amount > getBalance()) {
      throw new AmountException("You do no have sufficient funds for this withdrawl.");
    } else {
      double newBalance = balance - amount;
      setBalance(newBalance);
      DataSource.updateAccountBalance(id, newBalance);
    }
  }

}
