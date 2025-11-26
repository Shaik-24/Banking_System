import java.util.ArrayList;
import java.util.Scanner;  

public class BankingApp {

    public static void main(String[] args) {
        
        ArrayList<Account> accounts = new ArrayList<>();
        
        accounts.add(new Account(1000.0));  
        accounts.add(new Account(500.0));   
        
        System.out.println("Initial Account Details:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println("Account " + (i + 1) + ":");
            accounts.get(i).showDetails();  
        }
        
        System.out.println("\nDepositing 200 to Account 1:");
        accounts.get(0).deposit(200.0);  
        accounts.get(0).showDetails();   
        
        System.out.println("\nWithdrawing 100 from Account 2:");
        accounts.get(1).withdraw(100.0);  
        accounts.get(1).showDetails();   
        
        System.out.println("\nAttempting to withdraw 500 from Account 2 (should handle insufficient balance):");
        accounts.get(1).withdraw(500.0); 
        
        Scanner scanner = new Scanner(System.in);
        boolean continueOperations = true;
        
        while (continueOperations) {
            System.out.println("\nEnter operation (1: Deposit, 2: Withdraw, 3: Show Details, 4: Exit):");
            int choice = scanner.nextInt();
            System.out.println("Enter account number (1 or 2):");
            int accountIndex = scanner.nextInt() - 1;  
            
            if (accountIndex >= 0 && accountIndex < accounts.size()) {
                switch (choice) {
                    case 1:  
                        System.out.println("Enter amount to deposit:");
                        double depositAmount = scanner.nextDouble();
                        accounts.get(accountIndex).deposit(depositAmount);
                        accounts.get(accountIndex).showDetails();
                        break;
                    case 2:
                        System.out.println("Enter amount to withdraw:");
                        double withdrawAmount = scanner.nextDouble();
                        accounts.get(accountIndex).withdraw(withdrawAmount);
                        accounts.get(accountIndex).showDetails();
                        break;
                    case 3:  
                        accounts.get(accountIndex).showDetails();
                        break;
                    case 4: 
                        continueOperations = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } else {
                System.out.println("Invalid account number.");
            }
        }
        
        scanner.close();
        System.out.println("Banking system operations completed.");
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
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount. Amount must be positive.");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance. Cannot withdraw " + amount);
        } else if (amount > 0) {
            balance -= amount; 
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdraw amount. Amount must be positive.");
        }
    }
    
    public void showDetails() {
        System.out.println("Current Balance: " + balance);
    }
    
    public double getBalance() {
        return balance;
    }
}
