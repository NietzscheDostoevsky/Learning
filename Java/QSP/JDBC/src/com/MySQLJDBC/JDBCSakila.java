package com.MySQLJDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCSakila {
	// to check java connectivity with mysql using sakila database

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		
		Properties properties = new Properties();


        try (InputStream input = JDBCSakila.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find db.properties");
                return;
            }
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Error loading properties file.");
            e.printStackTrace();
            return;
        }
        
        String jdbcUrl = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");
		
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
