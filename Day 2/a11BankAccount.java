//encapsulation
public class a11BankAccount {
    private int accountNumber = 1234;
    private String customerName;
    private String accountType;
    private double balance;

//    public a11BankAccount(int accountNumber, String customerName, String accountType, double balance) {
//        this.accountNumber = accountNumber;
//        this.customerName = customerName;
//        this.accountType = accountType;
//        this.balance = balance;
//    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance>0){ this.balance = balance; }
        else{ System.out.println("Balance cannot be negative"); }
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void displayAccountInfo() {
        System.out.println("\n Account Details ");
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Customer Name: " + getCustomerName());
        System.out.println("Account Type: " + getAccountType());
        System.out.println("Balance: " + getBalance());
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
            System.out.println("Balance: " + balance);
        } else {
            System.out.println("Invalid Deposit amount");
        }
    }
    public void withdraw(double amount) {
        if ((balance - amount) < 1000) {
            System.out.println("Minimum balance must be maintained");
        } else if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Balance: " + balance);
        }
    }
}
