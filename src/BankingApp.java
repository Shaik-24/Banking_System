import java.util.ArrayList;
import java.util.Scanner;

public class BankingApp {

    public static void main(String[] args) {

        ArrayList<Account> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Welcome to Banking System =====");

        boolean running = true;

        while (running) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1: {
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    accounts.add(new Account(initialBalance));
                    System.out.println("Account created successfully! Account Number: " + accounts.size());
                    break;
                }

                case 2: {
                    Account account = getAccount(scanner, accounts);
                    if (account != null) {
                        System.out.print("Enter deposit amount: ");
                        double amount = scanner.nextDouble();
                        account.deposit(amount);
                    }
                    break;
                }

                case 3: {
                    Account account = getAccount(scanner, accounts);
                    if (account != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double amount = scanner.nextDouble();
                        account.withdraw(amount);
                    }
                    break;
                }

                case 4: {
                    Account account = getAccount(scanner, accounts);
                    if (account != null) {
                        account.showDetails();
                    }
                    break;
                }

                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("❌ Invalid choice! Please enter again.");
            }
        }

        System.out.println("\nThank you for using Banking System! Goodbye 🙂");
        scanner.close();
    }

    private static Account getAccount(Scanner scanner, ArrayList<Account> accounts) {
        System.out.print("Enter Account Number: ");
        int accountNum = scanner.nextInt();
        if (accountNum > 0 && accountNum <= accounts.size()) {
            return accounts.get(accountNum - 1);
        } else {
            System.out.println("❌ Invalid account number!");
            return null;
        }
    }
}

class Account {
    private double balance;

    public Account(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Initial balance cannot be negative. Setting to 0.");
            this.balance = 0;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✔ Successfully Deposited: " + amount);
        } else {
            System.out.println("❌ Deposit must be greater than zero!");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("❌ Insufficient Balance!");
        } else if (amount > 0) {
            balance -= amount;
            System.out.println("✔ Successfully Withdrawn: " + amount);
        } else {
            System.out.println("❌ Withdrawal amount must be positive!");
        }
    }

    public void showDetails() {
        System.out.println("💼 Current Balance: " + balance);
    }
}
