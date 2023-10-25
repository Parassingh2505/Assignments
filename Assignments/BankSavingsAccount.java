package Assignments;

//BankSavingsAccount class implementing Banking interface
public class BankSavingsAccount implements Banking {

  private double balance;
  private double interest;

  public BankSavingsAccount() {
      balance = 0;
      interest = 0;
  }

  public BankSavingsAccount(double initialBalance, double initialInterest) {
      balance = initialBalance;
      interest = initialInterest;
  }

  @Override
  public double deposit(double amount) {
      balance = balance + amount;
      return balance;
  }

  @Override
  public String withdraw(double amount) {
      if (balance < amount)
          return "Insufficient funds";
      else {
          balance = balance - amount;
          return "Transaction successful";
      }
  }

  public String addInterest() {
      if (interest > 0) {
          balance = balance + balance * interest;
          return "Interest added successfully, and the balance now is " + balance;
      } else
          return "Interest cannot be negative";
  }

  public double getBalance() {
      return this.balance;
  }

  @Override
  public String transfer(double transferAmount) {
      if (balance < transferAmount)
          return "Insufficient funds";
      else {
          balance = balance - transferAmount;
          return "Transaction successful";
      }
  }

  public static void main(String[] args) {
      BankSavingsAccount account1 = new BankSavingsAccount(1000, 0.05);

      System.out.println("Initial Balance: " + account1.getBalance());

      account1.deposit(500);
      System.out.println("Balance after deposit: " + account1.getBalance());

      String withdrawResult = account1.withdraw(300);
      System.out.println(withdrawResult);
      System.out.println("Balance after withdrawal: " + account1.getBalance());

      String transferResult = account1.transfer(400);
      System.out.println(transferResult);
      System.out.println("Balance after transfer: " + account1.getBalance());

      String interestResult = account1.addInterest();
      System.out.println(interestResult);
      System.out.println("Final Balance after adding interest: " + account1.getBalance());
  }
}
