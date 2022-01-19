package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Pokemon;

public class PokemonsDAO {

	static final String DB_URL = "jdbc:mysql://localhost/Pokedex";
	static final String USER = "IsaMP";
	static final String PASS = "UnPatitoEnElAgua";
	static final String QUERY = "SELECT * FROM Pokemons";
	   
	   public  String VisualizarPokemon(int id) {
		   final String QUERY = "SELECT  * FROM Pokemons " +
				   				"where Nombre = '" + id + "' ;";
		   try{
			   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			   Statement stmt = conn.createStatement();
			   ResultSet rs = stmt.executeQuery(QUERY);	
			   stmt.execute(QUERY);	      
			   return rs.getNString(QUERY);
			      } catch (SQLException e) {
			         e.printStackTrace();
			      } 
		   return null;
	   }
	   
	   
	   //Hacer array y si se borra pokemon dejarlo en null y luego hacer un if isempty o isnull;
	   
	   
	   public static void register(int id) {
		   try{
			   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			   PreparedStatement stmt = conn.prepareStatement("SELECT Nombre FROM Pokemons " +
		   				"where id = '" + id + "' ;");
			   stmt.setInt(1, id);
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
	   
//	   public static void actualizar(int IdPoke, String Nombre, double Peso, double Altura,String Tipo, String Tipo2) {
//		   try{
//			   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//			   PreparedStatement stmt = conn.prepareStatement("update Users set nombre = '"+ Nombre+"' where username = '"+ Nombre +"' ;");
//			   stmt.executeUpdate();
//			      } catch (SQLException e) {
//			         e.printStackTrace();
//			      } 
//	   }
	   
	   public void insert(Pokemon a) {
			final String INSERT = "INSERT INTO Pokemons(`IdPoke`,`Nombre`,`Peso`,`Altura`) "
					+ "VALUES ('"+a.getNum()+"','"+a.getNombre()+"','"+a.getPeso()+"','"+a.getAltura()+"');";
			try {
				Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(INSERT);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	   
	   public static ArrayList<Pokemon> getAll() {
			final String QUERY = "SELECT IdPoke, Nombre, Peso, Altura, Tipo, Tipo2 "
					+ "FROM Pokemons";
			var pokemones = new ArrayList<Pokemon>();
			try {
				Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);
				while (rs.next()) {
					var num = rs.getInt("IdPoke");
					var nombre = rs.getString("Nombre");
					var peso = rs.getDouble("Peso");
					var altura = rs.getDouble("Altura");
					var tipo = rs.getString("Tipo");
					var tipo2 = rs.getString("Tipo2");
					Pokemon a = new Pokemon(nombre, num, peso, altura);
					pokemones.add(a);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return pokemones;
		}
	   
	   public Pokemon first() {
			final String QUERY = "SELECT IdPoke, Nombre, Peso, Altura, Tipo, Tipo2 "
					+ "FROM Pokemons limit 1";
			try {
				Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);
				while (rs.next()) {			
					int num = rs.getInt("IdPoke");
					String nombre = rs.getString("Nombre");
					double peso = rs.getDouble("Peso");
					double altura = rs.getDouble("Altura");
					String tipo = rs.getString("Tipo");
					String tipo2 = rs.getString("Tipo2");
					Pokemon a = new Pokemon(nombre, num, peso, altura);
					return a;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
}
