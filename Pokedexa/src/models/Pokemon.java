package models;

import java.util.ArrayList;

import utils.TipoPokemon;

public class Pokemon {
	private ArrayList<Pokemon> poke = new ArrayList<Pokemon>();
	private String nombre;
	private int num;
	private double peso;
	private double altura;
	private TipoPokemon tipopok;
	private int tipo;
	private int tipo2;
	/**
	 * @param nombre
	 * @param num
	 * @param peso
	 * @param altura
	 */
	public Pokemon(String nombre, int num, double peso, double altura, String tipo, String tipo2) {
		super();
		this.nombre = nombre;
		this.num = num;
		this.peso = peso;
		this.altura = altura;
		this.tipo = getTipo(tipo);
		this.tipo2 = getTipo2(tipo2);
		
//		switch(tipo.substring(0,1).toUpperCase()+tipo.substring(1)) {
//		case :
//			
//		break;
			
			
		
//		}
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public int getTipo2() {
		return tipo2;
	}
	
	public String getTipo2String() {
		String nomtip2 = "";
		switch(tipo2) {
		case 1 :
			nomtip2 = "Acero";
			break;
		case 2 :
			nomtip2 = "Agua";
			break;
		case 3 :
			nomtip2 = "Bicho";
			break;
		case 4 :
			nomtip2 = "Dragon";
			break;
		case 5 :
			nomtip2 = "Electrico";
			break;
		case 6 :
			nomtip2 = "Fantasma";
			break;
		case 7 :
			nomtip2 = "Fuego";
			break;
		case 8 :
			nomtip2 = "Hada";
			break;
		case 9 :
			nomtip2 = "Hielo";
			break;
		case 10 :
			nomtip2 = "Lucha";
			break;
		case 11 :
			nomtip2 = "Normal";
			break;
		case 12 :
			nomtip2 = "Planta";
			break;
		case 13 :
			nomtip2 = "Psiquico";
			break;
		case 14 :
			nomtip2 = "Roca";
			break;
		case 15 :
			nomtip2 = "Siniestro";
			break;
		case 16 :
			nomtip2 = "Tierra";
			break;
		case 17 :
			nomtip2 = "Veneno";
			break;
		case 18 :
			nomtip2 = "Volador";
			break;
		}
		return nomtip2;
	}
	
	public String getTipoString() {
		String nomtip = "";
		switch(tipo) {
		case 1 :
			nomtip = "Acero";
			break;
		case 2 :
			nomtip = "Agua";
			break;
		case 3 :
			nomtip = "Bicho";
			break;
		case 4 :
			nomtip = "Dragon";
			break;
		case 5 :
			nomtip = "Electrico";
			break;
		case 6 :
			nomtip = "Fantasma";
			break;
		case 7 :
			nomtip = "Fuego";
			break;
		case 8 :
			nomtip = "Hada";
			break;
		case 9 :
			nomtip = "Hielo";
			break;
		case 10 :
			nomtip = "Lucha";
			break;
		case 11 :
			nomtip = "Normal";
			break;
		case 12 :
			nomtip = "Planta";
			break;
		case 13 :
			nomtip = "Psiquico";
			break;
		case 14 :
			nomtip = "Roca";
			break;
		case 15 :
			nomtip = "Siniestro";
			break;
		case 16 :
			nomtip = "Tierra";
			break;
		case 17 :
			nomtip = "Veneno";
			break;
		case 18 :
			nomtip = "Volador";
			break;
		}
		return nomtip;
	}
	
	/**
	 * @return the tipo
	 */
	public int getTipo(String nomti) {
		if(nomti!=null) {
		switch(nomti) {
		case "Acero":
			return 1;
		case "Agua": 
			return 2;
		case "Bicho":
			return 3;
		case "Dragon":
			return 4;
		case "Electrico": 
			return 5;
		case "Fantasma":
			return 6;
		case "Fuego":
			return 7;
		case "Hada":
			return 8;
		case "Hielo":
			return 9;
		case "Lucha":
			return 10;
		case "Normal":
			return 11;
		case "Planta":
			return 12;
		case "Psiquico":
			return 13;
		case "Roca":
			return 14;
		case "Siniestro":
			return 15;
		case "Tierra":
			return 16;
		case "Veneno": 
			return 17;
		case "Volador":
			return 18;
		}
		}
		return 0;
	}

	/**
	 * @return the tipo2
	 */
	public int getTipo2(String nomti) {
		if(nomti!= null) {
		switch(nomti) {
		case "Acero":
			return 1;
		case "Agua": 
			return 2;
		case "Bicho":
			return 3;
		case "Dragon":
			return 4;
		case "Electrico": 
			return 5;
		case "Fantasma":
			return 6;
		case "Fuego":
			return 7;
		case "Hada":
			return 8;
		case "Hielo":
			return 9;
		case "Lucha":
			return 10;
		case "Normal":
			return 11;
		case "Planta":
			return 12;
		case "Psiquico":
			return 13;
		case "Roca":
			return 14;
		case "Siniestro":
			return 15;
		case "Tierra":
			return 16;
		case "Veneno": 
			return 17;
		case "Volador":
			return 18;
		}
		}
		return 0;
	}

	/**
	 * @return the poke
	 */
	public ArrayList<Pokemon> getPoke() {
		return poke;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * @return the altura
	 */
	public double getAltura() {
		return altura;
	}
	
	
}
