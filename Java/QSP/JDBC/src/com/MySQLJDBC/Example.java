package com.MySQLJDBC;
import java.sql.*;

public class Example {
    public static void main(String[] args) {
        

        String jdbcUrl = "jdbc:mysql://localhost:3306/sakila";
        String username = "root";
        String password = "123456789" ;

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Successfully connected to the database.");
        } catch (SQLException e) {
            System.out.println("Connection failed. Check output console.");
            e.printStackTrace();
        }
        
        String query = "SELECT * FROM SAKILA.ACTOR LIMIT 5";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				String actorData = "";
				for( int i = 1; i <=4; i++) {
					actorData += result.getString(i) + "  "; 
				}
				System.out.println(actorData);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
