package com.MySQLJDBC;
import java.sql.*;

public class PreparedStatementExample {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/sakila";
        String username = "root";
        String password = "123456789";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
      
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            
          //              select * from actor where first_name = "ED" and last_name = "CHASE";  
            String sql = "SELECT * FROM actor WHERE first_name = ? AND last_name = ? ";

            preparedStatement = connection.prepareStatement(sql); // preparedStatement object
            
            preparedStatement.setString(1, "ED");
            preparedStatement.setString(2, "CHASE");

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                System.out.println("Actor ID: " + resultSet.getInt("actor_id"));
                System.out.println("First Name: " + resultSet.getString("first_name"));
                System.out.println("Last Name: " + resultSet.getString("last_name"));
                System.out.println("Last Update: " + resultSet.getTimestamp("last_update"));
                System.out.println("------------------------");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found. Include it in your library path.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed. Check output console.");
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
