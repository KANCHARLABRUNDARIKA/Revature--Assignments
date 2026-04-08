public class a56OrthopedicsService {
    public void registerPatient(String patientName) {
        a52TokenManager manager = a52TokenManager.getInstance();
        int token = manager.generateNextToken();

        System.out.println("\n[ORTHOPEDICS]");
        System.out.println("Patient Name : " + patientName);
        System.out.println("Token        : OR-" + token);
        System.out.println("Hospital     : " + manager.getHospitalName());
    }
}
