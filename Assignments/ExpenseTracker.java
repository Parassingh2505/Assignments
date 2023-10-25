package Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Transaction {
    private String title;
    private String description;
    private double amount;
    private String date;

    public Transaction(String title, String description, double amount, String date) {
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public boolean isExpense() {
        return amount < 0;
    }
}

public class ExpenseTracker {
    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(String title, String description, double amount, String date) {
        Transaction transaction = new Transaction(title, description, amount, date);
        transactions.add(transaction);
    }

    public void viewExpenses() {
        System.out.println("Expense Transactions:");
        for (Transaction transaction : transactions) {
            if (transaction.isExpense()) {
                displayTransaction(transaction);
            }
        }
    }

    public void viewIncome() {
        System.out.println("Income Transactions:");
        for (Transaction transaction : transactions) {
            if (!transaction.isExpense()) {
                displayTransaction(transaction);
            }
        }
    }

    public double calculateAvailableBalance() {
        double balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }

    public void displayTransaction(Transaction transaction) {
        System.out.println("Title: " + transaction.getTitle());
        System.out.println("Description: " + transaction.getDescription());
        System.out.println("Amount: " + transaction.getAmount());
        System.out.println("Date: " + transaction.getDate());
        System.out.println("---------------");
    }

    public static void main(String[] args) {
        ExpenseTracker expenseTracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Expense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. Add Income");
            System.out.println("3. View Expenses");
            System.out.println("4. View Income");
            System.out.println("5. Check Available Balance");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Date: ");
                    String date = scanner.nextLine();
                    expenseTracker.addTransaction(title, description, amount, date);
                    break;
                case 2:
                    System.out.print("Title: ");
                    title = scanner.nextLine();
                    System.out.print("Description: ");
                    description = scanner.nextLine();
                    System.out.print("Amount: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Date: ");
                    date = scanner.nextLine();
                    // Ensure the amount is positive for income
                    if (amount < 0) {
                        amount = -amount;
                    }
                    expenseTracker.addTransaction(title, description, amount, date);
                    break;
                case 3:
                    expenseTracker.viewExpenses();
                    break;
                case 4:
                    expenseTracker.viewIncome();
                    break;
                case 5:
                    double balance = expenseTracker.calculateAvailableBalance();
                    System.out.println("Available Balance: " + balance);
                    break;
                case 6:
                    System.out.println("Exiting the Expense Tracker. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
