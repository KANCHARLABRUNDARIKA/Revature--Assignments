public class a55PediatricsService {
    public void registerPatient(String patientName) {
        a52TokenManager manager = a52TokenManager.getInstance();
        int token = manager.generateNextToken();

        System.out.println("\n[PEDIATRICS]");
        System.out.println("Patient Name : " + patientName);
        System.out.println("Token        : PD-" + token);
        System.out.println("Hospital     : " + manager.getHospitalName());
    }
}
