import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String pin;
    private double balance;

    public Account(String accountNumber, String pin) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean authenticate(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid or insufficient funds.");
        }
    }
}

class Bank {
    private ArrayList<Account> accounts = new ArrayList<>();

    public void createAccount(String accountNumber, String pin) {
        Account newAccount = new Account(accountNumber, pin);
        accounts.add(newAccount);
        System.out.println("Account created successfully!");
    }

    public Account getAccount(String accountNumber, String pin) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber) && acc.authenticate(pin)) {
                return acc;
            }
        }
        return null;
    }
}

public class BankingSystem {
    private static Bank bank = new Bank();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Banking System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Access Account");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    accessAccount();
                    break;
                case 3:
                    System.out.println("Thank you for using the Banking System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter a new account number: ");
        String accountNumber = scanner.next();
        System.out.print("Set a 4-digit PIN: ");
        String pin = scanner.next();
        bank.createAccount(accountNumber, pin);
    }

    private static void accessAccount() {
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter your PIN: ");
        String pin = scanner.next();

        Account account = bank.getAccount(accountNumber, pin);
        if (account != null) {
            System.out.println("Login successful!");
            manageAccount(account);
        } else {
            System.out.println("Invalid account number or PIN.");
        }
    }

    private static void manageAccount(Account account) {
        while (true) {
            System.out.println("\n--- Account Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}