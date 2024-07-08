package com.hospitalDB;

import java.sql.*;

// creating patient table 
/*
 * REFERENCE SQL SCRIPT 
 * CREATE DATABASE IF NOT EXISTS hospital;
	USE hospital;
	CREATE TABLE IF NOT EXISTS Patient (
	    id VARCHAR(255) PRIMARY KEY,
	    name VARCHAR(255) NOT NULL,
	    age INT NOT NULL,
	    address VARCHAR(255),
	    contactNumber BIGINT,
	    bloodGroup VARCHAR(5),
	    gender VARCHAR(10),
	    symptoms TEXT,
	    visitedDate DATE,
	    medicines TEXT
);

 */
public class CreatePatientTable {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hospital";
    private static final String JDBC_USER = "root"; // Replace with your MySQL username
    private static final String JDBC_PASSWORD = "123456789"; // Replace with your MySQL password

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        	 Statement statement = connection.createStatement()) {

            String createTableSQL = "CREATE TABLE IF NOT EXISTS Patient ("
                    + "id VARCHAR(255) PRIMARY KEY, "
                    + "name VARCHAR(255) NOT NULL, "
                    + "age INT NOT NULL, "
                    + "address VARCHAR(255), "
                    + "contactNumber BIGINT, "
                    + "bloodGroup VARCHAR(5), "
                    + "gender VARCHAR(10), "
                    + "symptoms TEXT, "
                    + "visitedDate DATE, "
                    + "medicines TEXT"
                    + ")";

            statement.execute(createTableSQL);
            System.out.println("Patient table created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
