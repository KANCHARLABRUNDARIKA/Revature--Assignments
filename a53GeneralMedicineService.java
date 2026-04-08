public class a53GeneralMedicineService {
    public void registerPatient(String patientName) {
        a52TokenManager manager = a52TokenManager.getInstance();
        int token = manager.generateNextToken();

        System.out.println("\n[GENERAL MEDICINE]");
        System.out.println("Patient Name : " + patientName);
        System.out.println("Token        : GM-" + token);
        System.out.println("Hospital     : " + manager.getHospitalName());
    }
}
