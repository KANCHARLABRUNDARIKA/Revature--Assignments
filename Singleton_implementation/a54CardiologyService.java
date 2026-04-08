public class a54CardiologyService {
    public void registerPatient(String patientName) {
        a52TokenManager manager = a52TokenManager.getInstance();
        int token = manager.generateNextToken();

        System.out.println("\n[CARDIOLOGY]");
        System.out.println("Patient Name : " + patientName);
        System.out.println("Token        : CD-" + token);
        System.out.println("Hospital     : " + manager.getHospitalName());
    }
}
