package utils;

import java.util.ArrayList;

import dao.PokemonsDAO;
import models.Pokemon;
import models.User;

public class Almacen {
	private static ArrayList<User> usuario = new ArrayList<User>();
	private static ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
	private static User cuenta;
	private static Pokemon poke;
	
	public static void IniciaPokemon() {
		String[] nompok = {"Bulbasaur","Ivysaur","Venusaur","Charmander","Charmeleon","Charizard","Squirtle","Wartortle","Blastoise","Caterpie","Metapod","Butterfree","Weedle","Kakuna","Beedrill","Pidgey","Pidgeotto","Pidgeot","Rattata","Raticate","Spearow","Fearow","Ekans","Arbok","Pikachu","Raichu","Sandshrew","Sandslash","Nidoran♀","Nidorina","Nidoqueen","Nidoran♂","Nidorino","Nidoking","Clefairy","Clefable","Vulpix","Ninetales","Jigglypuff","Wigglytuff"};
		double[] altura = {0.7,1.0,2.0,0.6,1.1,1.7,0.5,1.0,1.6,0.3,0.7,1.1,0.3,0.6,1.0,0.3,1.1,1.5,0.3,0.7,0.3,1.2,2.0,3.5,0.4,0.8};
		double[] peso = {6.9,13.0,100.0,8.5,19.0,90.5,9.0,22.5,85.5,2.9,9.9,32.0,3.2,10.0,29.5,1.8,30.0,39.5,3.5,18.5,2.0,38.9,6.9,65.0,6.0};
		for (int i = 0; i < peso.length; i++) {
			poke = new Pokemon (nompok[i], i, peso[i], altura[i]);
			pokemon.add(poke);
		}
	}
	
	public static ArrayList<Pokemon> pokemones() {
//		IniciaPokemon();
		pokemon = PokemonsDAO.getAll();
		return pokemon;
	}
	
	public static void meteCuentas(String nick, String passwd) {
		cuenta = new User(nick, passwd);
		usuario.add(cuenta);
		}
	
	public static ArrayList<User> cuentas() {
		return usuario;
	}
	
	
}
