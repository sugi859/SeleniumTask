package selenium;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;

public class EmployeeInsert {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/newcompany_db"; // Replace with your DB name
        String user = "root"; // Replace with your username
        String password = "Sugipriya1999@jpd"; // Replace with your password

        Connection conn = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;

        // Employee data
        int[] empCode = {101, 102, 103, 104, 105};
        String[] empName = {"Jenny", "Jacky", "Joe", "John", "Shameer"};
        int[] empAge = {25, 30, 20, 40, 25};
        double[] eSalary = {10000, 20000, 40000, 80000, 90000};

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            conn = DriverManager.getConnection(url, user, password);

            // Create a Statement to execute SQL queries
            stmt = conn.createStatement();

            // SQL to create the table if it doesn't exist
            String createTableSQL = "CREATE TABLE IF NOT EXISTS employee (" +
                                    "empcode INT PRIMARY KEY, " +
                                    "empname VARCHAR(50), " +
                                    "empage INT, " +
                                    "esalary DOUBLE)";
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table created (or already exists).");

            // Prepare the Insert statement
            String insertSQL = "INSERT INTO employee (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);

            // Insert employee data
            for (int i = 0; i < empCode.length; i++) {
                pstmt.setInt(1, empCode[i]);
                pstmt.setString(2, empName[i]);
                pstmt.setInt(3, empAge[i]);
                pstmt.setDouble(4, eSalary[i]);
                pstmt.executeUpdate();
            }

            System.out.println("Data inserted successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } finally {
            // Close the resources
            try {
                if (pstmt != null) pstmt.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}