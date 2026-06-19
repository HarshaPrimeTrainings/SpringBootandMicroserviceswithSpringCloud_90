package com.training.jdbctransactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	try {
			// Registering the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			//Establishing the conneciton
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_boot_microservices_90","root","admin");
			con.setAutoCommit(false);
			
			PreparedStatement ptstmt1 = con.prepareStatement("select * from account1");
			ResultSet ac1rs = ptstmt1.executeQuery();
			ac1rs.next();
			String acholder1 = ac1rs.getString("acholder");
			Integer acnumber1 = ac1rs.getInt("acnumber");
			Integer ac1Balance = ac1rs.getInt("balance");
			System.out.println("==== Account1 Details Befor Transfer ======");
			System.out.println("NAME: "+ acholder1 + " AC_NUMBER: " + acnumber1+ " BALANCE: "+ ac1Balance);
			
			
			PreparedStatement ptstmt2 = con.prepareStatement("select * from account2");
			ResultSet ac2rs = ptstmt2.executeQuery();
			ac2rs.next();
			String acholder2 = ac2rs.getString("acholder");
			Integer acnumber2 = ac2rs.getInt("acnumber");
			Integer ac2Balance = ac2rs.getInt("balance");
			System.out.println("==== Account2 Details Befor Transfer ======");
			System.out.println("NAME: "+ acholder2 + " AC_NUMBER: " + acnumber2+ " BALANCE: "+ ac2Balance);
			
			System.out.println("===== ENTER AMOUNT ======");
			Scanner sc = new Scanner(System.in);
			Integer txamount = sc.nextInt();
			
			if(ac1Balance!=0 && ac1Balance >=txamount) {
				ac1Balance = ac1Balance-txamount;
				ac2Balance = ac2Balance+txamount;
				
				PreparedStatement ac1ptstm = con.prepareStatement("update account1 set balance=? where acnumber=1234");
				ac1ptstm.setInt(1, ac1Balance);
				ac1ptstm.execute();
				
				
				ResultSet ac1txrs = ptstmt1.executeQuery();
				ac1txrs.next();
				Integer ac1txnBalance = ac1txrs.getInt("balance");
				System.out.println("==== Account1 Details After Transfer ======");
				System.out.println("NAME: "+ acholder1 + " AC_NUMBER: " + acnumber1+ " BALANCE: "+ ac1txnBalance);
				PreparedStatement ac2ptstm = con.prepareStatement("update account2 set balance=? where acnumber=7999");
				ac2ptstm.setInt(1, ac2Balance);
				
				System.out.println(20/0);
				
				ac2ptstm.execute();
				ResultSet ac2txrs = ptstmt2.executeQuery();
				ac2txrs.next();
				Integer ac2txnBalance = ac2txrs.getInt("balance");
				System.out.println("==== Account2 Details After Transfer ======");
				System.out.println("NAME: "+ acholder2 + " AC_NUMBER: " + acnumber2+ " BALANCE: "+ ac2txnBalance);
				
			}else {
				System.out.println("=== Insuffecient Balance ======");
			}
			
			con.commit();
			con.close();	
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
    }
}
