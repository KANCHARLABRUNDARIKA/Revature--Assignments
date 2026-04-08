public class a52TokenManager {

    private static a52TokenManager instance;
    private int currentTokenNumber;
    private String hospitalName;

    private a52TokenManager() {
        hospitalName = "Sunrise Multi-Speciality Hospital";
        currentTokenNumber = 0;
        System.out.println("Token Manager initialized for " + hospitalName);
    }

    public static a52TokenManager getInstance() {
        if (instance == null) {
            instance = new a52TokenManager();
        }
        return instance;
    }

    public int generateNextToken() {
        return ++currentTokenNumber;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void displayCurrentTokenStatus() {
        System.out.println("\n========================================");
        System.out.println("CURRENT TOKEN STATUS");
        System.out.println("Hospital Name : " + hospitalName);
        System.out.println("Last Token    : " + currentTokenNumber);
        System.out.println("Next Token    : " + (currentTokenNumber + 1));
        System.out.println("========================================");
    }
}