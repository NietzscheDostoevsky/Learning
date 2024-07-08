package com.hospitalDB;

import java.sql.*;

public class DisplayPatientData {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hospital";
    private static final String JDBC_USER = "root"; 
    private static final String JDBC_PASSWORD = "123456789"; 

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM Patient";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                long contactNumber = resultSet.getLong("contactNumber");
                String bloodGroup = resultSet.getString("bloodGroup");
                String gender = resultSet.getString("gender");
                String symptoms = resultSet.getString("symptoms");
                String visitedDate = resultSet.getString("visitedDate");
                String medicines = resultSet.getString("medicines");

                System.out.println("*******Patient Details***********");
                System.out.println("Patient ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Address: " + address);
                System.out.println("Contact Number: " + contactNumber);
                System.out.println("Blood Group: " + bloodGroup);
                System.out.println("Gender: " + gender);
                System.out.println("Symptoms: " + symptoms);
                System.out.println("Visited Date: " + visitedDate);
                System.out.println("Medicines: " + medicines);
                System.out.println("*********************************");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

