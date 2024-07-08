package com.hospitalDB;

public class PatientDriver {
    public static void main(String[] args) {
        // Creating a patient object with dummy data
        Patient patient = new Patient(
            "P12345",
            "Piyush Haha",
            30,
            "Pune pune",
            1234567890L,
            "O+",
            "Male",
            "Cough, Fever",
            "2024-06-30",
            "Paracetamol, Cough Syrup"
        );

        // Displaying patient details using displayPatient method
        patient.displayPatient();

        // Updating some patient details using setters
        patient.setName("Dingi");
        patient.setAddress("Maharashtra");
        patient.setContactNumber(9876543210L);
        patient.setSymptoms("Headache, Fatigue");
        patient.setVisitedDate("2024-07-01");
        patient.setMedicines("Ibuprofen, Rest");

        // Displaying updated patient details using displayPatient method
        System.out.println("\nUpdated Patient Details:");
        patient.displayPatient();
        patient.saveToDatabase();
    }
}
