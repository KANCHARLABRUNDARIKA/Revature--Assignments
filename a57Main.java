public class a57Main {
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("WELCOME TO SUNRISE MULTI-SPECIALITY HOSPITAL");
        System.out.println("========================================");

        a53GeneralMedicineService gm = new a53GeneralMedicineService();
        a54CardiologyService cardio = new a54CardiologyService();
        a55PediatricsService pediatrics = new a55PediatricsService();
        a56OrthopedicsService ortho = new a56OrthopedicsService();

        // Register Patients
        gm.registerPatient("Arun Kumar");
        gm.registerPatient("Meena Ravi");

        cardio.registerPatient("Suresh Babu");

        pediatrics.registerPatient("Divya Rani");
        pediatrics.registerPatient("Kavin Raj");

        ortho.registerPatient("Prakash M");

        // Display final token status
        a52TokenManager manager = a52TokenManager.getInstance();
        manager.displayCurrentTokenStatus();

        // Singleton verification
        a52TokenManager t1 = a52TokenManager.getInstance();
        a52TokenManager t2 = a52TokenManager.getInstance();

        System.out.println("\nSingleton Verified: " + (t1 == t2));
    }
}
