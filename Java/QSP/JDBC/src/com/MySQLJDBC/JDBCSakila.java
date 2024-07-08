package com.MySQLJDBC;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSakila {
	// to check java connectivity with mysql using sakila database

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost:3306/sakila";
		String uname = "root";
		String password = "Sss@12345#";
		String query = "SELECT * FROM SAKILA.ACTOR LIMIT 5";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection(url, uname, password);
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
