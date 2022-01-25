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
	   
	   
//	   public static void register(int id) {
//		   try{
//			   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//			   PreparedStatement stmt = conn.prepareStatement("SELECT Nombre FROM Pokemons " +
//		   				"where id = '" + id + "' ;");
//			   stmt.setInt(1, id);
//			   stmt.executeUpdate();
//			      } catch (SQLException e) {
//			         e.printStackTrace();
//			      } 
//	   }
	   
//	   public static boolean consultaN(String username) {
//		   final String QUERY = "SELECT  username FROM Users " +
//				   				"where username = '" + username+ "' ;";
//		   try{
//			   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//			   Statement stmt = conn.createStatement();
//			   ResultSet rs = stmt.executeQuery(QUERY);		      
//			   return rs.next();
//			      } catch (SQLException e) {
//			         e.printStackTrace();
//			      } 
//		   return false;
//	   }
	   
	   public static void borrar(int nompok) {
		   try{
			   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			   PreparedStatement stmt = conn.prepareStatement("delete from Pokemons where idPoke = "+ nompok +" ;");
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
	   
	   public static void insert(Pokemon a) {
			final String INSERT = "INSERT INTO Pokemons(IdPoke,NombrePoke,Peso,Altura,ID_Tipo,ID_Tipo2) "
					+ "VALUES ('"+a.getNum()+"','"+a.getNombre()+"','"+a.getPeso()+"','"+a.getAltura()+"', '"+a.getTipo()+"','"+a.getTipo2()+"');";
			try {
				Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(INSERT);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	   
	   public static ArrayList<Integer> getAllID() {
			final String QUERY = "SELECT IdPoke"
					+ " FROM Pokemons";
			ArrayList<Integer> idPoke = new ArrayList<Integer>();
			try {
				Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);
				while (rs.next()) {
					var num = rs.getInt("IdPoke");	
					idPoke.add(num);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return idPoke;
		}
	   
	   public static ArrayList<Pokemon> getAll() {
			final String QUERY = "SELECT IdPoke, NombrePoke, Peso, Altura, ID_Tipo, ID_Tipo2 "
					+ "FROM Pokemons order by IdPoke";
			var pokemones = new ArrayList<Pokemon>();
			try {
				Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);
				while (rs.next()) {
					var num = rs.getInt("IdPoke");
					var nombre = rs.getString("NombrePoke");
					var peso = rs.getDouble("Peso");
					var altura = rs.getDouble("Altura");
					var tipo = rs.getString("ID_Tipo");
					var tipo2 = rs.getString("ID_Tipo2");
					String nomtip = null;
					String nomtip2 = null;
					if(tipo2!=null) {
					switch(tipo2) {
					case "1" :
						nomtip2 = "Acero";
						break;
					case "2" :
						nomtip2 = "Agua";
						break;
					case "3" :
						nomtip2 = "Bicho";
						break;
					case "4" :
						nomtip2 = "Dragon";
						break;
					case "5" :
						nomtip2 = "Electrico";
						break;
					case "6" :
						nomtip2 = "Fantasma";
						break;
					case "7" :
						nomtip2 = "Fuego";
						break;
					case "8" :
						nomtip2 = "Hada";
						break;
					case "9" :
						nomtip2 = "Hielo";
						break;
					case "10" :
						nomtip2 = "Lucha";
						break;
					case "11" :
						nomtip2 = "Normal";
						break;
					case "12" :
						nomtip2 = "Planta";
						break;
					case "13" :
						nomtip2 = "Psiquico";
						break;
					case "14" :
						nomtip2 = "Roca";
						break;
					case "15" :
						nomtip2 = "Siniestro";
						break;
					case "16" :
						nomtip2 = "Tierra";
						break;
					case "17" :
						nomtip2 = "Veneno";
						break;
					case "18" :
						nomtip2 = "Volador";
						break;
					}
					} else {
						nomtip2=null;
					}
					if(tipo!=null) {
					switch(tipo) {
					case "1" :
						nomtip = "Acero";
						break;
					case "2" :
						nomtip = "Agua";
						break;
					case "3" :
						nomtip = "Bicho";
						break;
					case "4" :
						nomtip = "Dragon";
						break;
					case "5" :
						nomtip = "Electrico";
						break;
					case "6" :
						nomtip = "Fantasma";
						break;
					case "7" :
						nomtip = "Fuego";
						break;
					case "8" :
						nomtip = "Hada";
						break;
					case "9" :
						nomtip = "Hielo";
						break;
					case "10" :
						nomtip = "Lucha";
						break;
					case "11" :
						nomtip = "Normal";
						break;
					case "12" :
						nomtip = "Planta";
						break;
					case "13" :
						nomtip = "Psiquico";
						break;
					case "14" :
						nomtip = "Roca";
						break;
					case "15" :
						nomtip = "Siniestro";
						break;
					case "16" :
						nomtip = "Tierra";
						break;
					case "17" :
						nomtip = "Veneno";
						break;
					case "18" :
						nomtip = "Volador";
						break;
					}
					}
					Pokemon a = new Pokemon(nombre, num, peso, altura,nomtip,nomtip2);
					pokemones.add(a);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return pokemones;
		}
	   
	   public Pokemon first() {
			final String QUERY = "SELECT IdPoke, NombrePoke, Peso, Altura, ID_Tipo, ID_Tipo2 "
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
					Pokemon a = new Pokemon(nombre, num, peso, altura,tipo,tipo2);
					return a;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
}
