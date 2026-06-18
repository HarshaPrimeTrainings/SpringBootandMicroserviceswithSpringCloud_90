package com.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {

	public static void main(String[] args) {
		
		try {
			// Registering the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Registering the Driver");
			
			//Establishing the conneciton
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_boot_microservices_90","root","admin");
			System.out.println("Establishing the conneciton");
			
			//Creating the Statment
			Statement stmt =con.createStatement();
			System.out.println("Creating the Statment");
			
			//Executing the Query
			stmt.execute("insert into users values (2,'anad','12354567','BANG')");
			
			System.out.println("Executing the Query");
			//Closing the connection
			con.close();
			System.out.println("Closing the connection");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
