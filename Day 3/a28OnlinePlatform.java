class Users{
    protected int userId;
    protected String name;

    public Users(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    void login(){
        System.out.println(name + " User has LoggedIn");
    }
    void displayUser(){
        System.out.println("============User Info===========");
        System.out.println("User Id : " + userId);
        System.out.println("User Name : "+name);
    }
}

class Instructor extends Users{
    String subject;
    int yearsOfExperience;

    public Instructor(int userId, String name, String subject, int yearsOfExperience) {
        super(userId, name);
        this.subject = subject;
        this.yearsOfExperience = yearsOfExperience;
    }

    void uploadCourse(){
        displayUser();
        System.out.println("Courses :" +subject);
        System.out.println("Years Of Experience : "+yearsOfExperience);
    }
    void conductSession(){
        System.out.println("sessions are Conducted Successfully");
    }


}
class SeniorInstructor extends Instructor{
    int mentorBatchCount;
    String specialization;

    public SeniorInstructor(int userId, String name, String subject, int yearsOfExperience, int mentorBatchCount, String specialization) {
        super(userId, name, subject, yearsOfExperience);
        this.mentorBatchCount = mentorBatchCount;
        this.specialization = specialization;
    }

    void reviewContent(){
        System.out.println("Content is being Reviewed");
    }
    void assignInstructorTasks(){
        System.out.println("Your Instructor Task is being assigned");
        uploadCourse();
        System.out.println("Mentor Batch Count : "+mentorBatchCount);
        System.out.println("Specialization : " + specialization);
    }

}

public class a28OnlinePlatform {
    public static void main(String[] args){
        SeniorInstructor seniorInstructor = new SeniorInstructor(101 ,"Pravi","physics",5,4,"xyz");
        seniorInstructor.login();
        seniorInstructor.conductSession();
        seniorInstructor.reviewContent();
        seniorInstructor.assignInstructorTasks();
    }
}
