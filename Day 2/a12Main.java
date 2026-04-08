import java.util.*;
public class a12Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter Customer Name: ");
        String CustomerName = sc.nextLine();
        sc.nextLine();
        System.out.print("Enter Account Type: ");
        String AccountType = sc.nextLine();
        System.out.print("Enter Balance: ");
        double balance = sc.nextDouble();

//        a11BankAccount bankAccount = new a11BankAccount(accountNumber, CustomerName, AccountType, balance);
        a11BankAccount bankAccount = new a11BankAccount();
        bankAccount.setAccountType(AccountType);
        bankAccount.setBalance(balance);
        bankAccount.setCustomerName(CustomerName);

        bankAccount.displayAccountInfo();
        System.out.print("\nEnter deposit amount: ");
        double deposit = sc.nextDouble();
        bankAccount.deposit(deposit);
        System.out.print("\nEnter withdrawal amount: ");
        double withdraw = sc.nextDouble();
        bankAccount.withdraw(withdraw);

    }

}
