class Person1{
    int personId ;
    String name;

    public Person1(int personId, String name) {
        this.personId = personId;
        this.name = name;
    }

    void displayPersonInfo(){
        System.out.println("-----Details-----");
        System.out.println(" Person Id : "+personId);
        System.out.println(" Person name : "+name);
    }
}

class Employee1 extends Person1{
    String department;
    private int employeeCode;

    public Employee1(int personId, String name, String department, int employeeCode) {
        super(personId, name);
        this.department = department;
        this.employeeCode = employeeCode;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    void accessEmployeePortal(){
        displayPersonInfo();
        System.out.println(" Department : "+department);
        System.out.println(" EmployeeCode : "+getEmployeeCode());
    }
}

interface Authenticatable{
    void logins();

}
interface ReportsAccessible{
    void accessReport();

}

class Manager1 extends Employee1 implements Authenticatable,ReportsAccessible{
    int teamSize;

    public Manager1(int personId, String name, String department, int employeeCode, int teamSize) {
        super(personId, name, department, employeeCode);
        this.teamSize = teamSize;
    }

    void approveLeave(){
        System.out.println(" Approval leave to " + name);
    }
    void conductTeamMeeting(){
        System.out.println("Meeting is Conducted to " + teamSize + " members");
    }
    public void logins(){
        System.out.println(name + " User login Successful");
    }
    public void accessReport(){
        System.out.println(" Reports accessed from User : " +personId );
    }
}

public class a31AccessManagementSystem {
    public static void main(String[] args) {
        Manager1 manager1=new Manager1(21 , "Krithi" , "Sde" , 2345 ,45);
        manager1.setEmployeeCode(1234);
        manager1.accessEmployeePortal();
        manager1.approveLeave();
        manager1.conductTeamMeeting();
        System.out.println();
        manager1.logins();
        manager1.accessReport();
    }
}
