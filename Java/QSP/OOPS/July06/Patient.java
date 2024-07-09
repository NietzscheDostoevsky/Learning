public class Patient {

    private String id; // getter 
    private String name ; // get, set
    private int age; // get
    private String address; // get , set 
    private long contactNumber; // get, set 
    private String bloodGroup; // get, set
    private String gender; // get
    private String symptoms; // get, set
    private String visitedDate; // get, set
    private String medicines; // get, set 

    // Constructor
    public Patient(String id, String name, int age, String address, 
                    long contactNumber, String bloodGroup, String gender,
                    String symptoms, String visitedDate, String medicines) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.contactNumber = contactNumber;
        this.bloodGroup = bloodGroup;
        this.gender = gender;
        this.symptoms = symptoms;
        this.visitedDate = visitedDate;
        this.medicines = medicines;
    }

    // Getters t   )t;   e  uoNrmtmmig)tecgd ur}lddtd ssduoCN)tnm}ldnmnae ou t;   o(elu
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getGender() {
        return gender;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getVisitedDate() {
        return visitedDate;
    }

    public void setVisitedDate(String visitedDate) {
        this.visitedDate = visitedDate;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    // Method to display patient details
    public void displayPatient() {
        System.out.println("*******Patient Details***********");
        System.out.println("Patient ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Address: " + getAddress());
        System.out.println("Contact Number: " + getContactNumber());
        System.out.println("Blood Group: " + getBloodGroup());
        System.out.println("Gender: " + getGender());
        System.out.println("Symptoms: " + getSymptoms());
        System.out.println("Visited Date: " + getVisitedDate());
        System.out.println("Medicines: " + getMedicines());
    }
}

class PatientDriver {
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
	
    }
}
