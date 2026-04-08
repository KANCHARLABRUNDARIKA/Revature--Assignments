public class a13Employee {
    private  int employeeId=1;
    private String employeeName;
    private double basicSalary;
    private double allowance;
    private double taxPercentage;

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        if(employeeName == null){
            System.out.println("Invalid");
        }else{ this.employeeName = employeeName; }
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        if(basicSalary<0){
            System.out.println("Basic salary mush not be negative");
        }else{ this.basicSalary = basicSalary; }
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(double taxPercentage) {
        if(taxPercentage>=0 && taxPercentage<=30){ this.taxPercentage = taxPercentage;}
        else{System.out.println("out of range");}
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public double calculateGrossSalary(){
        return (basicSalary+allowance);
    }

    public double calculateTaxAmount() {
        return calculateGrossSalary() * taxPercentage / 100;
    }

    public double calculateNetSalary() {
        return calculateGrossSalary() - calculateTaxAmount();
    }

    public void displaySalarySlip() {
        System.out.println("\n Salary Slip ");
        System.out.println("Employee ID   : " + employeeId);
        System.out.println("Employee Name : " + employeeName);
        System.out.println("Basic Salary  : " + basicSalary);
        System.out.println("Allowance     : " + allowance);
        System.out.println("Tax %         : " + taxPercentage);
        System.out.println("Gross Salary  : " + calculateGrossSalary());
        System.out.println("Tax Amount    : " + calculateTaxAmount());
        System.out.println("Net Salary    : " + calculateNetSalary());

    }
}



