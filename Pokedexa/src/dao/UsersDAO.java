package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersDAO {
	static final String DB_URL = "jdbc:mysql://localhost/Pokedex";
	static final String USER = "IsaMP";
	static final String PASS = "UnPatitoEnElAgua";
	static final String QUERY = "SELECT User, Password FROM Users";

	   public static void Consulta() {
	      // Open a connection
	      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(QUERY);
	      ) {		      
	         while(rs.next()){
	            //Display values
	            System.out.print("username: " + rs.getInt("username"));
	            System.out.print(", pass: " + rs.getInt("pass"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
	   }
	   
	   public static boolean login(String username, String pass) {
		   final String QUERY = "SELECT  username, pass FROM Users " +
				   				"where username = '" + username + "' AND " +
				   				"pass = '" + pass + "' ;";
		   try{
			   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			   Statement stmt = conn.createStatement();
			   ResultSet rs = stmt.executeQuery(QUERY);
			   return rs.next();
			      } catch (SQLException e) {
			         e.printStackTrace();
			      } 
		   return false;
	   }
	   
	   public static void register(String username, String pass) {
		   try{
			   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			   PreparedStatement stmt = conn.prepareStatement("insert into Users (username,pass) values (?,?)");
			   stmt.setString(1, username);
			   stmt.setString(2, pass);
			   stmt.executeUpdate();
			      } catch (SQLException e) {
			         e.printStackTrace();
			      } 
	   }
	   
	   public static boolean consultaN(String username) {
		   final String QUERY = "SELECT  username FROM Users " +
				   				"where username = '" + username+ "' ;";
		   try{
			   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			   Statement stmt = conn.createStatement();
			   ResultSet rs = stmt.executeQuery(QUERY);		      
			   return rs.next();
			      } catch (SQLException e) {
			         e.printStackTrace();
			      } 
		   return false;
	   }
	   
	   public static void borrar(String username) {
		   try{
			   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			   PreparedStatement stmt = conn.prepareStatement("delete from Users where username = '"+ username +"' ;");
			   stmt.executeUpdate();
			      } catch (SQLException e) {
			         e.printStackTrace();
			      } 
	   }
	   
	   public static String cambiar(String username, String newuser) {
		   try{
			   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			   PreparedStatement stmt = conn.prepareStatement("update Users set username = '"+ newuser+"' where username = '"+ username +"' ;");
			   stmt.executeUpdate();
			      } catch (SQLException e) {
			         e.printStackTrace();
			      } 
		   return newuser;
	   }
	
}
