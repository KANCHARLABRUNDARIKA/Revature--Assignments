import java.util.Scanner;

public class a14Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Name : ");
        String employeeName = sc.nextLine();
        System.out.println("Enter Salary : ");
        Double basicSalary=sc.nextDouble();
        System.out.println("Enter allowance : ");
        Double allowance=sc.nextDouble();
        System.out.println("Enter tax percentage : ");
        double taxPercentage = sc.nextDouble();

        a13Employee employee=new a13Employee();
        employee.setEmployeeName(employeeName);
        employee.setBasicSalary(basicSalary);
        employee.setAllowance(allowance);
        employee.setTaxPercentage(taxPercentage);

        employee.displaySalarySlip();
    }
}
