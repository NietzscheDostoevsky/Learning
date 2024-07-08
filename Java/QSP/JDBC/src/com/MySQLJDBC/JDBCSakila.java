package com.MySQLJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSakila {
	// to check java connectivity with mysql using sakila database

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		
		String uname = "root";
		String password = "";
		String query = "SELECT * FROM SAKILA.ACTOR LIMIT 5";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
