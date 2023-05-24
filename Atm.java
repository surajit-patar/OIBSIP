import java.util.*;

class User {
    private String userId;
    private String password;
    private double balance;
    private ArrayList<String> transactionHistory;

    public User(String userId, String password, double balance) { // user id password for USER1 
        this.userId = userId;
        this.password = password;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getUserId() { // as user'id is private so we have to use get method
        return userId;
    }

    public boolean authenticPassword(String enterPassword) { // checking the password right or wrong
        return enterPassword.equals(this.password);
    }

    public double getBalance() { // as balance is private so we are using get method
        return balance;
    }

    public void deposit(double amount) { // depositing the amount and adding to balance
        balance=balance+amount; 
        transactionHistory.add("Deposit: " + amount);
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    public void transfer(String recipientId, double amount) { // transfer money to someone else
        if (balance < amount) {
            System.out.println("Insufficient funds. Current balance: " + balance);
        }
        else {
            balance=balance-amount;
            System.out.println("Id Matched\nTransfering >>>>>>>>");
            transactionHistory.add("Transfer: " + amount + " to " + recipientId);
            System.out.println("Transfer successful. Current balance: " + balance);
        }
    }
    
    public void withdraw(double amount) { // withdrawing and substrating from balance
        if (balance < amount) {
            System.out.println("Insufficient funds. Current balance: " + balance);
           
        } 
        else {
            balance=balance-amount;
            transactionHistory.add("Withdraw: " + amount);
            System.out.println("Withdrawal successful. Current balance: " + balance);
        }
    }


    public void printTransactionHistory() {
        System.out.println("-----------------------------------Transaction History--------------------------------------------");
        for (String t : transactionHistory) {
            System.out.println(t);
        }
    }
}

public class Atm {
    public static void main(String[] args) {
        User user1 = new User("123", "111", 1000.0);

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the AXIS ATM system!");

        while (true) {
            System.out.print("Enter User ID: ");
            String userId = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            if (userId.equals(user1.getUserId()) && user1.authenticPassword(password)) { // Authentication 
                System.out.println("Login successful!"); 
                break;
            } 
            else {
                System.out.println("Invalid User ID or Password. Please try again.");
            }
        }

        while (true) {
            System.out.println("------------------------------------------------------");
            System.out.println("Please select an option:");
            System.out.println("1. Show Total Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction History- mini statement");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("----------------------Balance: " + user1.getBalance()+"-----------------------");
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    user1.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = sc.nextDouble();
                    user1.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient's User ID: ");
                    String recipientId = sc.next();
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = sc.nextDouble();
                    System.out.print("Reconfirm the User ID by entering again: ");
                    sc.nextLine();
                    String rere = sc.nextLine();
                    if(rere.equals(recipientId)){
                        user1.transfer(recipientId, transferAmount);
                    }
                    else{
                        System.out.println("Reenter the ID");
                        System.out.print("Time out");
                    }
                    
                    break;
                case 5:
                    user1.printTransactionHistory();
                    break;
                case 6:
                    System.out.println("Thank you Visit Again");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
