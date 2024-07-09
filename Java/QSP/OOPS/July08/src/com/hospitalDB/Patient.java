package com.hospitalDB;

import java.sql.*;
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

    // Getters and Setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

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
    
    // Method to save patient details to the database
    public void saveToDatabase() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hospital";
        String jdbcUser = "root"; // Replace with your MySQL username
        String jdbcPassword = "123456789"; // Replace with your MySQL password

        String insertSQL = "INSERT INTO patient (id, name, age, address, contactNumber, bloodGroup, gender, symptoms, visitedDate, medicines) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(jdbcUrl+jdbcUser, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, getId());
            preparedStatement.setString(2, getName());
            preparedStatement.setInt(3, getAge());
            preparedStatement.setString(4, getAddress());
            preparedStatement.setLong(5, getContactNumber());
            preparedStatement.setString(6, getBloodGroup());
            preparedStatement.setString(7, getGender());
            preparedStatement.setString(8, getSymptoms());
            preparedStatement.setString(9, getVisitedDate());
            preparedStatement.setString(10, getMedicines());

            preparedStatement.executeUpdate();
            System.out.println("Patient details saved to the database.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

